package iphomework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by liuyufei on 9/11/16.
 */
public class Ip2As {
    public static void main(String args[]) {
        if (args.length < 3) {
        /* always check the input to the program! */
            System.err.println("usage: ip2as <prefixes> <asnames> [ip0 ip1 .. ipN]");
            return;
        }

	/* read the prefix list into a list */
        ArrayList<prefix> list = new ArrayList<prefix>();
        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {
            String line;
        /* XXX: add code to parse the ip2as line */
//            192.240.136.0/24 27064
            while ((line = file.readLine()) != null) {
                String net = line.split("/")[0];
                int len = Integer.parseInt(line.split("/")[1].split(" ")[0]);
                String ases = line.split("/")[1].split(" ")[1];

		/* create a new prefix object and stuff it in the list */
                prefix pf = new prefix(net, len, ases);
                list.add(pf);
            }
            file.close();
        } catch (FileNotFoundException e) {
            System.err.println("could not open prefix file " + args[0]);
            return;
        } catch (IOException e) {
            System.err.println("error reading prefix file " + args[0] + ": " + e);
        }

	/*
	 * take the list of prefixes and transform it into a sorted array
	 * i'd like to thank my lecturer for giving me this code.
	 */
        prefix[] x = new prefix[list.size()];
        list.toArray(x);
        Arrays.sort(x, new prefixComparator());

	/*
	 * read in the asnames file so that we can report the
	 * network's name with its ASN
	 */
        Map<String, String> asnamesMap = new HashMap<>();
        try (BufferedReader file = new BufferedReader(new FileReader(args[1]))) {
            String line;
		/* XXX: add code to parse the ip2as line */
//          1239 SPRINTLINK - Sprint,US
            while ((line = file.readLine()) != null) {
                int space_index = line.indexOf(" ");
                String asname_key = line.substring(0,space_index);
                String asname_value = line.substring(space_index+1,line.length());
                asnamesMap.put(asname_key,asname_value);
            }
        } catch (FileNotFoundException e) {
            System.err.println("could not open prefix file " + args[1]);
            return;
        } catch (IOException e) {
            System.err.println("error reading prefix file " + args[1] + ": " + e);
        }

	/*
	 * for all IP addresses supplied on the command line, print
	 * out the corresponding ASes that announce a corresponding
	 * prefix, as well as their names.  if there is no
	 * corresponding prefix, print the IP address and then say no
	 * corresponding prefix.
	 */
        boolean isMatched = false;
        for (int i = 2; i < args.length; i++) {

	    /*
	     * x contains the sorted array of prefixes, organised longest
	     * to shortest prefix match
	     */
            for (int j = 0; j < x.length; j++) {
                /*
                 * XXX:
                 * check if this prefix matches the IP address passed in
                 */
                prefix p = x[j];
                isMatched = p.match(args[i]);
                if(isMatched){
                    if(p.asn.contains("_")){
                        String asn1 = p.asn.split("_")[0];
                        String asn2 = p.asn.split("_")[1];
                        System.out.println(args[i]+", "+p.net[0]+"."+p.net[1]+"."+p.net[2]+"."+p.net[3]+"."+"/"+p.len+", "+asn1+", "+asnamesMap.get(asn1));
                        System.out.println(args[i]+", "+p.net[0]+"."+p.net[1]+"."+p.net[2]+"."+p.net[3]+"."+"/"+p.len+", "+asn2+", "+asnamesMap.get(asn2));
                    }else{
                        System.out.println(args[i]+", "+p.net[0]+"."+p.net[1]+"."+p.net[2]+"."+p.net[3]+"."+"/"+p.len+", "+p.asn+", "+asnamesMap.get(p.asn));
                    }
                    break;
                }

            }
	    /*
	     * XXX:
	     * print something out if it was not matched
	     */
          if(!isMatched)
            System.out.println(args[i]+": no prefix");

        }
        return;
    }

}

/*
 * prefixComparator
 *
 * this class is used when sorting an array in Java.
 */
class prefixComparator implements Comparator<prefix> {
    public int compare(prefix a, prefix b) {
	/*
	 * XXX:
	 * return a value such that the array is ordered from
	 * most specific to least specific.  take a look at the
	 * documentation at
	 *
	 * http://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html
	 *
	 * on how the return value from this method will impact sort order.
	 * make sure the longest prefixes are sorted so that they come
	 * first!
	 */
        return b.len-a.len;
    }
};

/*
 * prefix
 *
 * this class holds details of a prefix: the network address, the
 * prefix length, and details of the autonomous systems that announce
 * it.
 *
 */
class prefix {
    public int[] net = {0, 0, 0, 0};
    public int len;
    public String asn;

    public prefix(String net, int len, String asn) {
        /*
	 * XXX:
	 * initialise the object given the inputs.  break
	 * the network ID into four integers.
	 */
        String[] netStr = net.split("\\.");
        this.net[0] = Integer.parseInt(netStr[0]);
        this.net[1] = Integer.parseInt(netStr[1]);
        this.net[2] = Integer.parseInt(netStr[2]);
        this.net[3] = Integer.parseInt(netStr[3]);

        this.len = len;
        this.asn = asn;

    }

    public String toString() {
	/* pretty print out of the prefix! my lecturer is kind! */
        return net[0] + "." + net[1] + "." + net[2] + "." + net[3] + "/" + len;
    }

    /*
     * match
     *
     * given an address, determine if it is found in this
     * prefix structure or not.
     */
    public boolean match(String addr) {
        int[] mask = {0x80, 0xC0, 0xE0, 0xF0, 0xF8, 0xFC, 0xFE, 0xFF};
        int left = -1;
        if (this.len % 8 != 0) {
            left = mask[this.len % 8 - 1];
        }
        int numof255 = this.len / 8;
        int subnet[] = {0, 0, 0, 0};
        for (int i = 0; i < numof255; i++) {
            subnet[i] = 0xFF;
        }
        if(left!=-1){
            subnet[numof255] = left;
        }

	/*
	 * XXX:
	 * break up the address passed in as a string
	 */
        String[] inputAddr = addr.split("\\.");
        int[] inputAddrInt = {0,0,0,0};
        inputAddrInt[0] = Integer.parseInt(inputAddr[0]);
        inputAddrInt[1] = Integer.parseInt(inputAddr[1]);
        inputAddrInt[2] = Integer.parseInt(inputAddr[2]);
        inputAddrInt[3] = Integer.parseInt(inputAddr[3]);
        boolean matched = true;
        for (int i = 0; i < 4; i++) {
	    /*
	     * XXX:
	     * compare up to four different values in the dotted quad,
	     * (i.e. enough to cover this.len) to determine if this
	     * address is a match or not
	     */
            if((inputAddrInt[i]&subnet[i])!=(this.net[i]&subnet[i])){
                matched = false;
                break;
            }
        }
        return matched;

    }
}

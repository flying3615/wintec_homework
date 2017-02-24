package six_problems

/**
  * Created by liuyufei on 18/02/17.
  */

class BankAccount{

  private var balance = 0

  //synchronized
  def deposit(amount:Int):Unit = this.synchronized{
    if(amount>0) balance+=amount
  }

  //synchronized
  def withdraw(amount:Int):Int = this.synchronized{
    if(amount>0&&balance>=amount){
      //current thread sleep for 1 second to simulate dirty-read in multithreading
      Thread.sleep(1000)
      balance-=amount
      balance
    }else{
      throw new Exception("insufficient funds")
    }
  }
}

class MyThread(var bankAccount: BankAccount) extends Runnable{
  override def run(): Unit = {
    println(s"in ${Thread.currentThread().getName}, after withdraw 100, balance is ${bankAccount.withdraw(100)}")
  }
}


object Prog3 extends App {

  val bankAccount = new BankAccount
  println("deposit 100 to account")
  bankAccount.deposit(100)

  //start two thread, in normal case, the second thread should throw "insufficient funds error"
  new Thread(new MyThread(bankAccount)).start()
  new Thread(new MyThread(bankAccount)).start()


}

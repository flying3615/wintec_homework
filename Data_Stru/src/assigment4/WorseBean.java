package assigment4;

public class WorseBean extends Bean{

	private Integer dataObject;

	public WorseBean(Integer dataObject){
		this.dataObject = dataObject;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorseBean other = (WorseBean) obj;
		if (dataObject == null) {
			if (other.dataObject != null)
				return false;
		} else if (!dataObject.equals(other.dataObject))
			return false;
		return true;
	}



}

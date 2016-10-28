package assigment4;

public class BetterBean extends Bean{

	private Integer dataObject;

	public BetterBean(Integer dataObject){
		this.dataObject = dataObject;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataObject == null) ? 0 : dataObject.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BetterBean other = (BetterBean) obj;
		if (dataObject == null) {
			if (other.dataObject != null)
				return false;
		} else if (!dataObject.equals(other.dataObject))
			return false;
		return true;
	}



}

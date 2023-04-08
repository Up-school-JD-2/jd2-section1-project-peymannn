package jd2_Section1_Project;

public interface ITransaction {

	public boolean addData(Data data);

	public Data searchDataByName(String dataName);

	public boolean removeData(long id);

	public int findIndexInArrayById(long Id);

	public void printListData();
}

package jd2_Section1_Project;

public class UserTransactions implements ITransaction {

	private User[] users = new User[Constants.DATA_OPENING_COUNT];
	private int itemCount = 0;

	@Override
	public boolean addData(Data data) {
		int index = findIndexInArrayById(data.getId());
		if (index != -1) {
			return false;
		}
		if (itemCount == users.length - 1) {
			reInitializeArray();
		}
		if (data instanceof User currentUser) {
			users[itemCount] = (User) data;
			itemCount++;
			return true;
		}
		return false;
	}

	private void reInitializeArray() {
		User[] newUserArray = new User[users.length + Constants.DATA_OPENING_COUNT];
		System.arraycopy(users, 0, newUserArray, 0, users.length);
		users = newUserArray;
	}

	@Override
	public Data searchDataByName(String dataName) {

		for (int i = 0; i < itemCount; i++) {
			if (users[i].getName() == dataName) {
				return users[i];
			}
		}
		return null;
	}

	public boolean login(String dataName, String password) {
		if (itemCount == 0) {
			System.out.println("hiç kullanıcı yok,Lütfen kullanıcı ekleyin");
			return false;
		}
		for (int i = 0; i < itemCount; i++) {
			if (users[i].getName().equals(dataName) && users[i].getPassword().equals(password)) {
				System.out.println("Başarılı giriş :)");
				return true;
			}
		}
		System.out.println("Başarısız giriş :(");
		return false;
	}

	@Override
	public boolean removeData(long id) {
		int index = findIndexInArrayById(id);
		if (index != -1) {
			for (int i = index; i < itemCount; i++) {
				users[i] = users[i + 1];
			}
			users[itemCount - 1] = null;
			itemCount--;
			return true;
		}
		return false;
	}

	@Override
	public int findIndexInArrayById(long id) {
		int index = -1;
		for (int i = 0; i < itemCount; i++) {
			if (users[i].getId() == (id)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public void printListData() {
		for (int i = 0; i < itemCount; i++) {
			System.out.print(users[i]);
			System.out.println();
		}
	}

}

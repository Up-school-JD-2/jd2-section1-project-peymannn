package jd2_Section1_Project;

public class FilmTransactions implements ITransaction {

	private Film[] films = new Film[Constants.DATA_OPENING_COUNT];
	private int itemCount = 0;

	@Override
	public boolean addData(Data data) {
		int index = findIndexInArrayById(data.getId());
		if (index != -1) {
			return false;
		}

		if (itemCount == films.length - 1) {
			reInitializeArray();
		}
		if (data instanceof Film currentFilm) {
			films[itemCount] = (Film) data;
			itemCount++;
			return true;
		}
		return false;
	}

	private void reInitializeArray() {
		Film[] newFilmArray = new Film[films.length + Constants.DATA_OPENING_COUNT];
		System.arraycopy(films, 0, newFilmArray, 0, films.length);
		films = newFilmArray;
	}

	@Override
	public Data searchDataByName(String dataName) {
		for (int i = 0; i < itemCount; i++) {
			if (films[i].getName().contains(dataName)) {
				return films[i];
			}
		}
		return null;
	}

	@Override
	public boolean removeData(long id) {
		int index = findIndexInArrayById(id);
		if (index != -1) {
			for (int i = index; i < itemCount; i++) {
				films[i] = films[i + 1];
			}
			films[itemCount - 1] = null;
			itemCount--;
			return true;
		}
		return false;
	}

	@Override
	public int findIndexInArrayById(long id) {
		int index = -1;
		for (int i = 0; i < itemCount; i++) {
			if (films[i].getId() == (id)) {
				index = i;
				break;
			}
		}
		return index;
	}

	@Override
	public void printListData() {
		for (int i = 0; i < itemCount; i++) {
			System.out.print(films[i]);
			System.out.println();
		}
	}

}

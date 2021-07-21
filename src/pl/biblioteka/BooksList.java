package pl.biblioteka;

import pl.biblioteka.Singleton.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksList {
    private Connection connection;
    dbConnection con = dbConnection.getInstance();
    private List<String> bestsellersList = new ArrayList<>();
    private List<String> biographyList = new ArrayList<>();
    private List<String> novelList = new ArrayList<>();

    public List<String> getBestsellersList() {
        return bestsellersList;
    }

    public List<String> getBiographyList() {
        return biographyList;
    }

    public List<String> getNovelList() {
        return novelList;
    }

    public BooksList() throws SQLException {
    }

    public void addList(ResultSet result) throws SQLException {
        while (result.next()) {
            String resultName = result.getString("name");
            int resultBookType = result.getInt("book_type");
            if (resultBookType == 1) {
                novelList.add(resultName);
            } else if (resultBookType == 2) {
                biographyList.add(resultName);
            }else if(resultBookType == 3){
                 bestsellersList.add(resultName);
            }
        }
    }

    public void getAllBooks() throws SQLException {

        PreparedStatement ps = con.getConnection().prepareStatement("SELECT * FROM book");
        ResultSet result = con.executeSelect(ps);
        addList(result);
    }


}

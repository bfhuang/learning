package repository;

import domain.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BookRepository {
    private JdbcTemplate template;

    public BookRepository(JdbcTemplate jdbcTemplate){
        this.template = jdbcTemplate;
    }

    public void insert(Book book) {
        String sql = String.format("insert into book values(%d,'%s',%s,'%s');", book.getIsbn(), book.getName(), book.getPrice(), book.getAuthor());

        template.execute(sql);
    }

    public List<Book> query() {
        String sql = "select * from book;";
        return template.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book book = new Book();
                book.setIsbn(rs.getInt("isbn"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setAuthor(rs.getString("author"));
                return book;
            }
        });
    }


}

package org.gaeng.test;

import org.gaeng.dao.BoardDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

@SpringBootTest
public class PagingTest {

    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void pagingTest() throws SQLException {
        boardDAO.paging(3).forEach(i-> System.out.println(i));
        System.out.println(boardDAO.totalCount());
    }
}

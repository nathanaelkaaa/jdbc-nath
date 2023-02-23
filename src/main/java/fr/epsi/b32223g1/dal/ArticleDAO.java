package fr.epsi.b32223g1.dal;


import fr.epsi.b32223g1.bo.Article;

import java.sql.SQLException;
import java.util.List;

public interface ArticleDAO {
    void insert(Article article) throws SQLException;

    List<Article> findAll() throws SQLException;

    void update(Article oldArticle, Article newArticle) throws SQLException;

    void delete(int articleId) throws SQLException;

    Double moyenne() throws SQLException;
}


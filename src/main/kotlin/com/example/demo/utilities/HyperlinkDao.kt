package com.example.demo.utilities

import com.example.demo.model.Hyperlink

class HyperlinkDao {
    fun addHyperlink(hyperlink: Hyperlink) {
        val connection = Database().connection
        val preparedStatement = connection.prepareStatement("INSERT INTO Hyperlink(title, url) VALUES(?, ?)")
        preparedStatement.setString(1, hyperlink.title)
        preparedStatement.setString(2, hyperlink.url)
        preparedStatement.executeUpdate()
        preparedStatement.close()
        connection.close()
    }

    fun readHyperlink(): List<Hyperlink> {
        val connection = Database().connection
        val resultSet = connection
                .createStatement()
                .executeQuery("SELECT * FROM Hyperlink WHERE date_deleted IS NULL")
        val hyperlinkList = ArrayList<Hyperlink>()
        while (resultSet.next()) {
            val title = resultSet.getString("title")
            val url = resultSet.getString("url")
            hyperlinkList += Hyperlink(title, url)
        }
        resultSet.close()
        connection.close()
        return hyperlinkList
    }
}
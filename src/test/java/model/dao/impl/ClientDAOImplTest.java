package model.dao.impl;

import model.db.DatabaseConnection;
import model.entity.Client;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.powermock.api.mockito.PowerMockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ClientDAOImplTest {

    private DatabaseConnection databaseConnectionMock;
    private Connection connectionMock;
    private PreparedStatement preparedStatementMock;
    private ClientDAOImpl clientDAO;

    @BeforeEach
    void setUp() throws Exception {
        databaseConnectionMock = mock(DatabaseConnection.class);
        connectionMock = mock(Connection.class);
        preparedStatementMock = mock(PreparedStatement.class);

        when(databaseConnectionMock.getConnection()).thenReturn(connectionMock);
        when(connectionMock.prepareStatement(anyString())).thenReturn(preparedStatementMock);

        clientDAO = new ClientDAOImpl(databaseConnectionMock);
    }

    @Test
    void createClient() throws SQLException {
        Client client = new Client(
                12345678,
                "Juan",
                "Perez"
        );
        String query =  "INSERT INTO client (dni, name, last_name) VALUES (?, ?, ?)";
        clientDAO.createClient(client);
        verify(databaseConnectionMock, times(1)).getConnection();
        verify(connectionMock, times(1)).prepareStatement(query);
        verify(preparedStatementMock, times(1)).setInt(1, client.getDni());
        verify(preparedStatementMock, times(1)).setString(2, client.getName());
        verify(preparedStatementMock, times(1)).setString(3, client.getLastName());
        verify(preparedStatementMock, times(1)).executeUpdate();
        verify(preparedStatementMock, times(1)).close();
    }
}
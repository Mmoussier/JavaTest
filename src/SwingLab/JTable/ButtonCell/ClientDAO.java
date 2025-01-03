package SwingLab.JTable.ButtonCell;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// Accès à la base mysql désactivé (ne fonctionne pas)
public class ClientDAO {
    private static Connection con;
    private static ArrayList<Client> clients;

    public ClientDAO(){
        if(con == null){
            String dbUrl = "jdbc:mysql://localhost:3306/hotel";
            String dbClass = "com.mysql.jdbc.Driver";

            clients = new ArrayList<>();
            Client client = new Client("Morgann","Orléans","1234","mm.mm@a.com");
            clients.add(client);

//            try {
//                Class.forName(dbClass);
//                con = DriverManager.getConnection (dbUrl, "root", "12345678");
//            }catch(Exception e) {
//                e.printStackTrace();
//            }
        }
    }

    /**
     * search all clients in the tblClient whose name contains the @key
     * @param key
     * @return list of client whose name contains the @key
     */
    public ArrayList<Client> searchClient(String key){
        return clients;
//        ArrayList<Client> result = new ArrayList<Client>();
//        String sql = "SELECT * FROM tblClient WHERE name LIKE ?";
//        try{
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, "%" + key + "%");
//            ResultSet rs = ps.executeQuery();
//
//            while(rs.next()){
//                Client client = new Client();
//                client.setId(rs.getInt("id"));
//                client.setName(rs.getString("name"));
//                client.setAddress(rs.getString("address"));
//                client.setTel(rs.getString("tel"));
//                client.setEmail(rs.getString("email"));
//                client.setNote(rs.getString("note"));
//                result.add(client);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return result;
    }

    /**
     * update the @client
     * @param client
     */
    public void editClient(Client client){
        String sql = "UPDATE tblClient SET name=?, address=?, tel=?, email=?, note=? WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, client.getName());
            ps.setString(2, client.getAddress());
            ps.setString(3, client.getTel());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getNote());
            ps.setInt(6, client.getId());

            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * delete the client whose id is @id
     * @param id
     */
    public void deleteClient(int id){
        String sql = "DELETE FROM tblClient WHERE id=?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
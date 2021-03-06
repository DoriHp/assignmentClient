/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
/**
 *
 * @author noobf
 */
public class RoomRegistration extends javax.swing.JPanel {
    String room = "";
    String workingDir = System.getProperty("user.dir");
    File userInfo = new File(workingDir + "/temp/userInfo.txt");
    /**
     * Creates new form RoomRegistration
     * @throws java.io.IOException
     */
    public RoomRegistration() throws IOException {
        initComponents();
        tbRooms.setTableHeader(null);
        setRoomIndex(tbRooms);
        setColor(tbRooms, recieveInfo());
    }
    
    private void setRoomIndex(JTable table){
        TableModel tcm = table.getModel(); 
        int index = 100;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                tcm.setValueAt(index, i, j);
                index++;
            }
        }    
    }
    
    private void setColor (JTable table, StringBuffer value) throws IOException{
        String[] array1d = value.toString().split("");
        String array2d[][] = new String[10][10];
        for(int i=0; i<10;i++)
           for(int j=0; j<10;j++)
               array2d[i][j] = array1d[(j*10) + i]; 
        ColoringCellRenderer cellRenderer = new ColoringCellRenderer();
        TableColumnModel columnModel = table.getColumnModel();
        int cc = columnModel.getColumnCount();
        for (int c=0; c<cc; c++)
        {
            TableColumn column = columnModel.getColumn(c);
            column.setCellRenderer(cellRenderer);
        }
        for(int i=0; i<10; i++)
           for(int j=0; j<10; j++){
               if("8".equals(String.valueOf(array2d[i][j])) ){
                   cellRenderer.setCellColor(j, i, Color.RED);
               }else{
                   cellRenderer.setCellColor(j, i, Color.GREEN);
               }
           }
    }
    
    private StringBuffer recieveInfo() throws MalformedURLException, IOException{
        String url = "http://localhost:3000/api/room";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
		BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
        return response;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRooms = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btConfirm = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        btBack = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đăng kí phòng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));

        tbRooms.setFont(new java.awt.Font("Anonymous Pro", 1, 12)); // NOI18N
        tbRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "", "", "", "", "", "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRooms.setRowHeight(40);
        tbRooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRoomsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbRooms);
        if (tbRooms.getColumnModel().getColumnCount() > 0) {
            tbRooms.getColumnModel().getColumn(0).setResizable(false);
            tbRooms.getColumnModel().getColumn(1).setResizable(false);
            tbRooms.getColumnModel().getColumn(2).setResizable(false);
            tbRooms.getColumnModel().getColumn(3).setResizable(false);
            tbRooms.getColumnModel().getColumn(4).setResizable(false);
            tbRooms.getColumnModel().getColumn(5).setResizable(false);
            tbRooms.getColumnModel().getColumn(6).setResizable(false);
            tbRooms.getColumnModel().getColumn(7).setResizable(false);
            tbRooms.getColumnModel().getColumn(8).setResizable(false);
            tbRooms.getColumnModel().getColumn(9).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Danh sách phòng:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Đã đầy");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Còn trống");

        btConfirm.setText("<html>&#10004; Đăng ký");
        btConfirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConfirmMouseClicked(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(204, 0, 0));

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 204, 0));

        btBack.setText("<html>Back ↵");
        btBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBackMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(107, 107, 107)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(74, 74, 74)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(23, 142, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private JPanel RoomRegistration;
    /**
     * Xác định panel sẽ hiển thị khi muốn xem thông tin chi tiết của 1 sinh viên
     * @param RoomRegistration
     */
    public void PnBacktoMain(JPanel RoomRegistration){
        this.RoomRegistration = RoomRegistration;
    }; 
    private void btBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBackMouseClicked
        // TODO add your handling code here:
        JFrame parent = Utitilities.findJFrameOf(this);
        if (parent != null) {
            parent.setContentPane(RoomRegistration);
                parent.pack();
            } else {
                JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
                System.exit(1);
            }
    }//GEN-LAST:event_btBackMouseClicked

    private void btConfirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConfirmMouseClicked
        try {
            // TODO add your handling code here:
            sendReq();
        } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, "Oops!Some thing went wrong~~", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btConfirmMouseClicked

    private void tbRoomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRoomsMouseClicked
        // TODO add your handling code here:
        int row = tbRooms.getSelectedRow();
        int col = tbRooms.getSelectedColumn();
        room = tbRooms.getValueAt(row, col).toString();
    }//GEN-LAST:event_tbRoomsMouseClicked

    private String getInfo() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(userInfo));   
        String st = "";  
        st = br.readLine();
        String[] arr = st.split("/");
        br.close();
        return arr[0];
    }
    
    private void sendReq() throws IOException{
        int select = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng kí vào phòng " + room,
                "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(select == JOptionPane.NO_OPTION){
            return;
        }else{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPut httpput = new HttpPut("http://localhost:3000/api/room/register/" + room);
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("id", getInfo()));
            try{
                httpput.setHeader("Accept", "application/x-www-form-urlencoded");
                httpput.setHeader("Content-Type", "application/x-www-form-urlencoded");
                httpput.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
                System.out.println("Requesting:" + httpput.getRequestLine());
                HttpResponse response = httpclient.execute(httpput);
                int responseCode = response.getStatusLine().getStatusCode();
                if(responseCode == 200){
                    JOptionPane.showMessageDialog(null, "Đăng kí phòng thành công",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                            setColor(tbRooms, recieveInfo());
                }else{
                    JOptionPane.showMessageDialog(null, "Đã có lỗi xảy ra!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Oops!Some thing went wrong~~", "Error", JOptionPane.ERROR_MESSAGE);
            }finally{
                httpclient.getConnectionManager().shutdown();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btConfirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable tbRooms;
    // End of variables declaration//GEN-END:variables
}

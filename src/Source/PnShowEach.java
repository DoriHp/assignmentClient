/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author noobf
 */
public class PnShowEach extends javax.swing.JPanel {
    /**
     * Creates new form PnShowEach
     * @throws java.io.IOException
     */
    String workingDir = System.getProperty("user.dir");
    public PnShowEach() throws IOException
    {  
        initComponents();
    }
    
    private String[] getInfo() throws FileNotFoundException, IOException{
        File info = new File(workingDir + "/temp/info.txt");
        BufferedReader br = new BufferedReader(new FileReader(info));   
        String st = "";  
        st = br.readLine();
        String[] arr = st.split("/");
        br.close();
        return arr;
    }
    
    private StringBuffer getInfo(String[] maSV) throws MalformedURLException, IOException{
        String url = "http://localhost:3000/api/getInfo?maSV=64101";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        
        BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        //System.out.println(response.toString());
        return response;
    }
    
    private String getImage(String nameSV){
        try{
            File file;
            file = File.createTempFile("image", ".jpg", new File(workingDir + "/temp"));
            file.deleteOnExit();
            String params = "";
            params += "name=" + URLEncoder.encode(nameSV, "UTF-8");
            String url = "http://localhost:3000/api/image?" + params;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            InputStream is = con.getInputStream();
            FileOutputStream out = new FileOutputStream( file );
            byte[] data = new byte[4096];
            int readBytes = 0;
            while ((readBytes = is.read(data)) > 0) {
              out.write(data,0,readBytes);
            }
            out.flush();
            out.close();
            is.close();
            return file.getPath();
        }catch (IOException ex){
            System.out.println(ex.toString());
            return null;
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTittle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbInfo = new javax.swing.JTable();
        btBack = new javax.swing.JButton();
        btChange = new javax.swing.JButton();
        btShow = new javax.swing.JButton();
        thumb = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbmaSV = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản lý thông tin cá nhân", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));

        lbTittle.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbTittle.setText("HỒ SƠ SINH VIÊN");

        tbInfo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tbInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Họ và tên", null},
                {"Giới tính", null},
                {"Lớp", null},
                {"Số điện thoại", null},
                {"Địa chỉ email", null},
                {"Quên quán", null},
                {"Số CMND", null},
                {"Ngày sinh", null},
                {"Mã phòng kí túc", null},
                {"Số lần vi phạm quy chế", null}
            },
            new String [] {
                "Thông tin", "Chi tiết"
            }
        ));
        tbInfo.setAutoscrolls(false);
        tbInfo.setRowHeight(25);
        jScrollPane1.setViewportView(tbInfo);
        if (tbInfo.getColumnModel().getColumnCount() > 0) {
            tbInfo.getColumnModel().getColumn(0).setResizable(false);
            tbInfo.getColumnModel().getColumn(0).setPreferredWidth(70);
            tbInfo.getColumnModel().getColumn(1).setResizable(false);
            tbInfo.getColumnModel().getColumn(1).setPreferredWidth(230);
        }

        btBack.setText("<html>Back ↵");
        btBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btBackMouseClicked(evt);
            }
        });

        btChange.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btChange.setText("Chỉnh sửa");
        btChange.setEnabled(false);
        btChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btChangeMouseClicked(evt);
            }
        });

        btShow.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btShow.setText("Hiển thị");
        btShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btShowMouseClicked(evt);
            }
        });

        thumb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        thumb.setMaximumSize(new java.awt.Dimension(160, 240));
        thumb.setMinimumSize(new java.awt.Dimension(160, 240));
        thumb.setPreferredSize(new java.awt.Dimension(160, 240));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel1.setText("ID:");

        btDelete.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btDelete.setText("Xóa");
        btDelete.setEnabled(false);
        btDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDeleteMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Font Awesome 5 Free Solid", 0, 18)); // NOI18N
        jLabel2.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbmaSV)
                        .addGap(0, 618, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(thumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btShow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btChange, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbTittle))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbmaSV))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTittle)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(thumb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btChange)
                    .addComponent(btShow)
                    .addComponent(btDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private JPanel pnMoreInfo;
    /**
     * Xác định panel sẽ hiển thị khi muốn xem thông tin chi tiết của 1 sinh viên
     * @param pnMoreInfo
     */
    public void PnBacktoMain(JPanel pnMoreInfo){
        this.pnMoreInfo = pnMoreInfo;
    }; 
    
    private void btBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btBackMouseClicked
        JFrame parent = Utitilities.findJFrameOf(this);
        if (parent != null) {
            thumb.setIcon(null);
            lbmaSV.setText("");
            btDelete.setEnabled(false);
            btChange.setEnabled(false);
            int i = 0;
            for(; i < 10 ; i++){
                tbInfo.getModel().setValueAt("", i, 1);
            }
            parent.setContentPane(pnMoreInfo);
                parent.pack();
            } else {
                JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
                System.exit(1);
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_btBackMouseClicked
    
    private void initInfo(String[] arr){
        TableModel tcm = tbInfo.getModel();
        int i = 1;
        for(; i <= 10; i++){
            tcm.setValueAt(arr[i], i-1, 1);
        }
    }
    
    private void btShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btShowMouseClicked
        String nameSV;
        try {
            initInfo(getInfo());
            nameSV = getInfo()[1];
            String imgURL = getImage(nameSV);
            ImageIcon icon = new ImageIcon(imgURL); 
            thumb.setIcon(icon);
            lbmaSV.setText(getInfo()[0]);
        } catch (IOException ex) {
            Logger.getLogger(PnShowEach.class.getName()).log(Level.SEVERE, null, ex);
        }
        btDelete.setEnabled(true);
        btChange.setEnabled(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btShowMouseClicked
    
    private void sendDelReq() throws MalformedURLException, IOException{
        int select = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa bản ghi?",
                "Chú ý", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(select == JOptionPane.NO_OPTION){
            return;
        }else{
            String maSV = lbmaSV.getText();
            maSV = URLEncoder.encode(maSV, "UTF-8");
            HttpClient httpclient = new DefaultHttpClient();
            HttpDelete httpdel = new HttpDelete("http://localhost:3000/api/delete/" + maSV);
            try{
                httpdel.setHeader("Accept", "application/json");
                System.out.println("Requesting : " + httpdel.getRequestLine());
                HttpResponse response = httpclient.execute(httpdel);
                int responseCode = response.getStatusLine().getStatusCode();
                String responseBody = response.getStatusLine().getReasonPhrase();
                if(responseCode == 200){
                    JOptionPane.showMessageDialog(null, "Xóa thông tin học sinh thành công!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Lỗi!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("Response code:" +  responseCode + "/nResponseBody:" + responseBody);
            }catch(ClientProtocolException e){
                JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.INFORMATION_MESSAGE);
            }finally{
                httpclient.getConnectionManager().shutdown();
            }
        }
    }
    private void btDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDeleteMouseClicked
        try {
            sendDelReq();
        } catch (IOException ex) {
            Logger.getLogger(PnShowEach.class.getName()).log(Level.SEVERE, null, ex);
        }
        btBackMouseClicked(evt);
    }//GEN-LAST:event_btDeleteMouseClicked
    
    private String[] getInfoFromTB() throws UnsupportedEncodingException{
        String[] arr = new String[10];
        int i = 0;
        for(; i < 10; i++){
            String words = (String)tbInfo.getModel().getValueAt(i, 1);
            if(words == null){
                JOptionPane.showMessageDialog(null, "Nhập thiếu thông tin", "Chú ý", JOptionPane.INFORMATION_MESSAGE);
                break;
            }else{
                arr[i] = new String(words);
            }
        }
        return arr;
    }
    
    private void sendPut() throws IOException{
        int select = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn sửa bản ghi?",
                "Chú ý", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(select == JOptionPane.NO_OPTION){
            return;
        }else{
            String[] arr = getInfoFromTB();
            int i = 0;
            for(; i < 10; i++){
                if(arr[i] == null) return;
            }
            String maSV = lbmaSV.getText();
            HttpClient httpclient = new DefaultHttpClient();
            HttpPut httpput = new HttpPut("http://localhost:3000/api/put/" + maSV);
            String[] nameBody = {"name", "gender", "phone", "email", "birthday",
            "city", "class", "identify", "room", "times"};
             i = 0;
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            for(; i < 10; i++){
                nvps.add(new BasicNameValuePair(nameBody[i], arr[i]));
            }
            try{
                httpput.setHeader("Accept", "application/x-www-form-urlencoded");
                httpput.setHeader("Content-Type", "application/x-www-form-urlencoded");
                httpput.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
                System.out.println("Requesting : " + httpput.getRequestLine());
                HttpResponse response = httpclient.execute(httpput);
                int responseCode = response.getStatusLine().getStatusCode();
                String responseBody = response.getStatusLine().getReasonPhrase();
                if(responseCode == 200){
                    JOptionPane.showMessageDialog(null, "Sửa thông tin học sinh thành công!",
                            "Success", JOptionPane.INFORMATION_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(null, "Lỗi!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                System.out.println("Response code:" +  responseCode + "/nResponseBody:" + responseBody);
            }catch(ClientProtocolException e){
                JOptionPane.showMessageDialog(null, "Oops!Some thing went wrong~~", "Error", JOptionPane.ERROR_MESSAGE);
            }finally{
                httpclient.getConnectionManager().shutdown();
            }
        }
    }
    
    private void btChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btChangeMouseClicked
        try {
            sendPut();
            // TODO add your handling code here:
        }catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Oops!Some thing went wrong~~", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btChangeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btChange;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTittle;
    private javax.swing.JLabel lbmaSV;
    private javax.swing.JTable tbInfo;
    private javax.swing.JLabel thumb;
    // End of variables declaration//GEN-END:variables
}

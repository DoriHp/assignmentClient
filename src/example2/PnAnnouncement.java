/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author noobf
 */
public class PnAnnouncement extends javax.swing.JPanel {
    String workingDir = System.getProperty("user.dir");
    File file;
    /**
     * Creates new form PnAnnouncement
     */
    public PnAnnouncement() {
        initComponents();
        txtContent.setLineWrap(true);
        txtContent.setWrapStyleWord(true);
    }
    
    private void saveContent() throws IOException{
        if("".equals(txtTitle.getText()) || "".equals(txtContent.getText()) ){
            JOptionPane.showMessageDialog(null, "Điền đầy đủ theo mẫu", "Lỗi!", JOptionPane.ERROR);
            return;
        }
        String title = txtTitle.getText();
        file = File.createTempFile(title, ".txt", new File(workingDir + "/temp"));
        file.deleteOnExit();
        FileWriter fw = new FileWriter(file, false);
        fw.write(txtContent.getText());
        fw.close();
    }
    
    private String getInfo() throws FileNotFoundException, IOException{
        File info = new File(workingDir + "/temp/userInfo.txt");
        BufferedReader br = new BufferedReader(new FileReader(info));   
        String st = "";  
        st = br.readLine();
        String[] arr = st.split("/");
        br.close();
        return arr[0];
    }
    
    private void createAnnouncement() throws UnsupportedEncodingException, IOException{
        StringBody id = new StringBody(getInfo());
        String title = URLEncoder.encode(txtTitle.getText(), "UTF-8");
        HttpClient httpclient =  new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://localhost:3000/users/createAnnounce");
        try{
            FileBody bin = new FileBody(file);
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart("announce", bin);
            reqEntity.addPart("title", new StringBody(title));
            reqEntity.addPart("makerID", id);
            httppost.setEntity(reqEntity);
            System.out.println("Requesting : " + httppost.getRequestLine());
            HttpResponse httpres = httpclient.execute(httppost);
            int code = httpres.getStatusLine().getStatusCode();
            if(code == 200){
                JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công!",
                        "Thành công", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(ClientProtocolException e){
            
        }finally{
            httpclient.getConnectionManager().shutdown();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        btSubmit = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tạo thông báo mới", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));

        txtContent.setColumns(20);
        txtContent.setRows(5);
        jScrollPane1.setViewportView(txtContent);

        jLabel1.setText("Nội dung thông báo");

        jLabel2.setText("Tiêu đề");

        btSubmit.setText("Hoàn tất");
        btSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSubmitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtTitle))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(469, Short.MAX_VALUE)
                .addComponent(btSubmit)
                .addGap(144, 144, 144))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btSubmit)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSubmitMouseClicked
        int option = JOptionPane.showConfirmDialog(null, "Xác nhận thêm tin thông báo?",
                "Xác nhận" ,JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            try {
                saveContent();
                createAnnouncement();
                // TODO add your handling code here:
            } catch (IOException ex) {
                Logger.getLogger(PnCreateNew.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            return;
        }
    }//GEN-LAST:event_btSubmitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}

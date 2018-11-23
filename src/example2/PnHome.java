/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.io.FileWriter;
import java.net.URLEncoder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author cibervn
 */
public class PnHome extends javax.swing.JPanel {
    private final String USER_AGENT = "Mozilla/5.0";
    String workingDir = System.getProperty("user.dir");
    /**
     * Creates new form PnHome
     */
    public PnHome() {
        initComponents();
        btPre.setVisible(false);
        btNext.setVisible(false);
        jbNow.setVisible(false);
        jbTotal.setVisible(false);
        jLabel1.setVisible(false);
        jLabel3.setVisible(false);
    }
    int page = 0;
    Image img;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDS = new javax.swing.JTable();
        btNext = new javax.swing.JButton();
        btPre = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jbNow = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbTotal = new javax.swing.JLabel();
        btDisplay = new javax.swing.JButton();
        btMoreInfo = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        cbSearch = new javax.swing.JComboBox();
        btAdd = new javax.swing.JButton();
        btUserInfo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btEditAnnounment = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giao diện chính", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(700, 600));
        setMinimumSize(new java.awt.Dimension(700, 600));
        setPreferredSize(new java.awt.Dimension(700, 600));

        tbDS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbDS.setGridColor(new java.awt.Color(255, 255, 255));
        tbDS.setRowHeight(25);
        tbDS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDS);

        btNext.setText("<html>Next page &#9658;");
        btNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btNextMouseClicked(evt);
            }
        });

        btPre.setText("<html>&#9668; Preview page\n");
        btPre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPreMouseClicked(evt);
            }
        });

        jLabel1.setText("Page");

        jbNow.setText("0");

        jLabel3.setText("/");

        jbTotal.setText("0");

        btDisplay.setBackground(new java.awt.Color(255, 0, 0));
        btDisplay.setText("Xem danh sách");
        btDisplay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDisplayMouseClicked(evt);
            }
        });

        btMoreInfo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btMoreInfo.setForeground(new java.awt.Color(255, 0, 0));
        btMoreInfo.setText("<html>&#926; Chi tiết");
        btMoreInfo.setEnabled(false);
        btMoreInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btMoreInfoMouseClicked(evt);
            }
        });

        btSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btSearch.setForeground(new java.awt.Color(204, 0, 0));
        btSearch.setText("<html>&#8853; Tìm kiếm");
        btSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSearchMouseClicked(evt);
            }
        });

        cbSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Họ tên", "Lớp" }));

        btAdd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btAdd.setForeground(new java.awt.Color(204, 0, 0));
        btAdd.setText("<html>&#8226; Bổ sung");
        btAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btAddMouseClicked(evt);
            }
        });

        btUserInfo.setFont(new java.awt.Font("Font Awesome 5 Free Solid", 0, 14)); // NOI18N
        btUserInfo.setForeground(new java.awt.Color(204, 0, 0));
        btUserInfo.setText("\n");
        btUserInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btUserInfoMouseClicked(evt);
            }
        });

        jLabel2.setText("Quản lý sinh viên");

        jSeparator1.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setText("Quản lý người dùng\n");

        jButton2.setFont(new java.awt.Font("Font Awesome 5 Free Solid", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(204, 0, 0));
        jButton2.setText("");

        btEditAnnounment.setFont(new java.awt.Font("Font Awesome 5 Free Solid", 0, 14)); // NOI18N
        btEditAnnounment.setForeground(new java.awt.Color(204, 0, 0));
        btEditAnnounment.setText("");
        btEditAnnounment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btEditAnnounmentMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(289, 334, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jbNow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbTotal)
                        .addGap(18, 18, 18)
                        .addComponent(btPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btNext, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btAdd, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btMoreInfo, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btDisplay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEditAnnounment, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(btDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btMoreInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btUserInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEditAnnounment, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jbNow)
                    .addComponent(jLabel3)
                    .addComponent(jbTotal))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void AddComponent(StringBuffer value) throws Exception{
        String[] result = value.toString().split("/");
        System.out.println(result);
        Vector cols=new Vector();
            cols.addElement("Mã sinh viên");
            cols.addElement("Tên sinh viên");
            cols.addElement("Giới tính");
            cols.addElement("Lớp");
            cols.addElement("Số điện thoại");
            cols.addElement("Email");
            cols.addElement("Quê quán");
            cols.addElement("Số CMND");
            cols.addElement("Ngày sinh");
            cols.addElement("Số phòng");
            cols.addElement("Số lần vi phạm quy chế");
        Vector data=new Vector();
        int length = result.length - 1;
        String id, tenSV, gender, classNo, phone, email, city, identify, 
                birthday, room, times; 
        for(int i = 0; (i + 11) <= length ; i += 11){
            id = String.valueOf(result[i]);
            tenSV = String.valueOf(result[i + 1]);
            gender = String.valueOf(result[i + 2]);
            classNo = String.valueOf(result[i + 3]);
            phone = String.valueOf(result[i + 4]);
            email = String.valueOf(result[i + 5]);
            birthday = String.valueOf(result[i + 6]);
            city = String.valueOf(result[i + 7]);
            identify = String.valueOf(result[i + 8]);
            room = String.valueOf(result[i + 9]);
            times = String.valueOf(result[i + 10]);
            Vector sv = new Vector();
            sv.addElement(id);
            sv.addElement(tenSV);
            sv.addElement(gender);
            sv.addElement(classNo);
            sv.addElement(phone);
            sv.addElement(email);
            sv.addElement(city);
            sv.addElement(identify);
            sv.addElement(birthday);
            sv.addElement(room);
            sv.addElement(times);
            data.add(sv);
        }
        tbDS.setModel(new DefaultTableModel(data, cols));
        tbDS.setGridColor(Color.blue);
        tbDS.setShowGrid(true);
        TableColumnModel tcm = tbDS.getColumnModel();
        tcm.removeColumn(tcm.getColumn(10));
        tcm.removeColumn(tcm.getColumn(8));
        tcm.removeColumn(tcm.getColumn(7));
        tcm.removeColumn(tcm.getColumn(6));
        tcm.removeColumn(tcm.getColumn(5));
        tcm.removeColumn(tcm.getColumn(4));
        jbTotal.setText(result[result.length - 1]);
        jbNow.setText(String.valueOf(page + 1));
        btPre.setVisible(true);
        btNext.setVisible(true);
        jbNow.setVisible(true);
        jbTotal.setVisible(true);
        jLabel1.setVisible(true);
        jLabel3.setVisible(true);
    };
    private void btNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btNextMouseClicked
        try {
            // TODO add your handling code here:
            page++;
            if(page == Integer.parseInt(jbTotal.getText())){
                page--;
            }
            AddComponent(sendGet(page));
        } catch (Exception ex) {
            System.out.printf(ex.toString());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btNextMouseClicked

    private void btPreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPreMouseClicked
        try {
            // TODO add your handling code here:
            page--;
           if(page < 0){
                page++;
            }
            AddComponent(sendGet(page));
        } catch (Exception ex) {
            System.out.printf(ex.toString());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btPreMouseClicked

    private void btDisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDisplayMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            AddComponent(sendGet(page));
        } catch (Exception ex) {
            System.out.printf(ex.toString());
        }
    }//GEN-LAST:event_btDisplayMouseClicked
    
    /**
     *
     */
    private JPanel pnHomeIndex1;
    /**
     * Xác định panel sẽ hiển thị khi muốn xem thông tin chi tiết của 1 sinh viên
     * @param pnHomeIndex1
     */
    public void setPnHomeIndex1(JPanel pnHomeIndex1){
        this.pnHomeIndex1 = pnHomeIndex1;
    };
    
    private JPanel pnHomeIndex2;
    /**
     * Xác định panel sẽ hiển thị khi muốn xem thông tin chi tiết của 1 sinh viên
     * @param pnHomeIndex2
     * /*/
    public void setPnHomeIndex2(JPanel pnHomeIndex2){
        this.pnHomeIndex2 = pnHomeIndex2;
    };
    
    private JPanel pnHomeIndex3;
    /**
     * Xác định panel sẽ hiển thị khi muốn thay đổi thông tin người dùng
     * @param pnHomeIndex3
     * /*/
    public void setPnHomeIndex3(JPanel pnHomeIndex3){
        this.pnHomeIndex3 = pnHomeIndex3;
    };
    
    private JPanel pnHomeIndex4;
    /**
     * Xác định panel sẽ hiển thị khi muốn thay đổi thông tin người dùng
     * @param pnHomeIndex4
     * /*/
    public void setPnHomeIndex4(JPanel pnHomeIndex4){
        this.pnHomeIndex4 = pnHomeIndex4;
    };
     
    private void btMoreInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMoreInfoMouseClicked
        JFrame parent = Utitilities.findJFrameOf(this);
        if (parent != null) {
            parent.setContentPane(pnHomeIndex1);
            parent.pack();
        } else {
            JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
            System.exit(1);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btMoreInfoMouseClicked

    private void btSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMouseClicked
        String choosen = cbSearch.getSelectedItem().toString();
        String params = "";
        try{
        if(choosen == "Họ tên"){
            params += "name=" + URLEncoder.encode(txtSearch.getText(), "UTF-8");
        }
        else{
            params += "class=" + URLEncoder.encode(txtSearch.getText(), "UTF-8");
        }
        String url = "http://localhost:3000/api/search?" + params;
        
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            //add request header
            con.setRequestProperty("User-Agent", USER_AGENT);

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
            System.out.println("Response Data : " + response);
            
            in.close();
            params = "";
            AddComponent(response);
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hơp!",
                "Lỗi tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btSearchMouseClicked

    private void tbDSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDSMouseClicked
        btMoreInfo.setEnabled(true);
        int select;
        select = tbDS.getSelectedRow();
        String info = "";
        int i = 0;
        for(; i <= 10 ; i++){
            info +=tbDS.getModel().getValueAt(select,i).toString() + "/";
        }
        File masvFile = new File(workingDir + "/temp/info.txt");
        try {
        FileWriter f2 = new FileWriter(masvFile, false);
            f2.write(info);
            f2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }          
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDSMouseClicked

    private void btAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMouseClicked
        JFrame parent = Utitilities.findJFrameOf(this);
        if (parent != null) {
            parent.setContentPane(pnHomeIndex2);
            parent.pack();
        } else {
            JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
            System.exit(1);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btAddMouseClicked

    private void btUserInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUserInfoMouseClicked
        // TODO add your handling code here:
        JFrame parent = Utitilities.findJFrameOf(this);
        if (parent != null) {
            parent.setContentPane(pnHomeIndex3);
            parent.pack();
        } else {
            JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
            System.exit(1);
        }
    }//GEN-LAST:event_btUserInfoMouseClicked

    private void btEditAnnounmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEditAnnounmentMouseClicked
        // TODO add your handling code here:
        JFrame parent = Utitilities.findJFrameOf(this);
        if (parent != null) {
            parent.setContentPane(pnHomeIndex4);
            parent.pack();
        } else {
            JOptionPane.showMessageDialog(parent, "Panel Login only used for JFrame");
            System.exit(1);
        }
    }//GEN-LAST:event_btEditAnnounmentMouseClicked

    private StringBuffer sendGet(int params) throws Exception {
		String url = "http://localhost:3000/api/index?page=" + String.valueOf(params);
		
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
                return response;
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDisplay;
    private javax.swing.JButton btEditAnnounment;
    private javax.swing.JButton btMoreInfo;
    private javax.swing.JButton btNext;
    private javax.swing.JButton btPre;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btUserInfo;
    private javax.swing.JComboBox cbSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jbNow;
    private javax.swing.JLabel jbTotal;
    private javax.swing.JTable tbDS;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

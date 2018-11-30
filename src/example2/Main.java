/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package example2;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author cibervn
 */

public class Main extends javax.swing.JFrame {

    private PnLogin pnLogin;
    private PnHome pnHome;
    private PnShowEach pnShowEach;
    private PnCreateNew pnCreateNew;
    private PnUserInfo pnUserInfo;
    private PnAnnouncement pnAnnouncement;
    private PnStudentHome pnStudentHome;
    private RoomRegistration pnRoomRegistration; 
    String workingDir = System.getProperty("user.dir");
    File userInfo = new File(workingDir + "/temp/userInfo.txt");
    /**
     * Creates new form Main
     * @throws java.io.IOException
     */
    public Main() throws IOException, Exception {
      
        initComponents();

        //Khởi tạo các Panel của ứng dụng
        initPanels();
        //Set icon cho ứng dụng 
        ImageIcon img = new ImageIcon(workingDir + "/icon/jframe_icon.jpg");
        this.setIconImage(img.getImage());
        
        //Xây dựng giao diện ban đầu cho ứng dụng
        setContentPane(pnLogin);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e){
                int select = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn thoát ứng dụng?",
                "Chú ý", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if(select == JOptionPane.YES_OPTION){
                    try { 
                        FileUtils.cleanDirectory(new File(workingDir + "/temp/"));
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.exit(0);
                }else if(select == JOptionPane.NO_OPTION){
                    return;
                }
            }
        });      
    }

    private void initPanels() throws IOException, Exception {
        pnLogin = new PnLogin();
        pnHome = new PnHome();
        pnShowEach = new PnShowEach();
        pnCreateNew = new PnCreateNew();
        pnUserInfo = new PnUserInfo();
        pnAnnouncement = new PnAnnouncement();
        pnStudentHome = new PnStudentHome();
        pnRoomRegistration = new RoomRegistration();
        //Xác định navigation
        //Sau khi đăng nhập thành công sẽ chuyển sang giao diện của PnHome
        pnLogin.setPnLoginSuccess(pnHome);
        pnLogin.setPnLoginSuccess2(pnStudentHome);
        pnHome.setPnHomeIndex1(pnShowEach);
        pnHome.setPnHomeIndex2(pnCreateNew);
        pnHome.setPnHomeIndex3(pnUserInfo);
        pnHome.setPnHomeIndex4(pnAnnouncement);
        pnUserInfo.PnBacktoMain(pnHome);
        pnShowEach.PnBacktoMain(pnHome);
        pnCreateNew.PnBacktoMain(pnHome);
        pnAnnouncement.PnBacktoMain(pnHome);
        pnRoomRegistration.PnBacktoMain(pnStudentHome);
        pnStudentHome.PnGoToRR(pnRoomRegistration);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý sinh viên kí túc xá");
        setResizable(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}

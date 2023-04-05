package pbl4_giamsatmanglan;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
 import java.io.IOException;
import java.io.InputStream;
 import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
 import java.util.concurrent.ConcurrentSkipListSet;
 import java.util.concurrent.ExecutorService;
 import java.util.concurrent.Executors;
 import java.util.concurrent.TimeUnit;
 import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
 import javax.swing.Timer;

public class GiaoDien extends javax.swing.JFrame {
    Timer tm;
    ServerSocket serverSocket = new ServerSocket(8000);  
    DataInputStream dis;
    DataOutputStream dos;
    
    public GiaoDien() throws IOException{       
        initComponents();
 
        tm = new Timer(0, new ActionListener() {
   
        @Override
        public void actionPerformed(ActionEvent e) {
            ConcurrentSkipListSet networkIps = scan("10.249.93.1", 1);
            String t =  XuLyChuoi(networkIps, "zone1");
            String[] str1 = t.split("\\$");
            jTextArea1.setText(str1[0]);
        
            ConcurrentSkipListSet networkIps1 = scan("172.16.1.1", 100);
            String t1 =  XuLyChuoi(networkIps1, "zone2");
            String[] str2 = t1.split("\\$");
            jTextArea2.setText(str2[0]);
             
            ConcurrentSkipListSet networkIps2 = scan("192.168.1.1", 50);
            String t2 =  XuLyChuoi(networkIps2, "zone3");
            String[] str3 = t2.split("\\$");
            jTextArea3.setText(str3[0]);    
            
            int MayBan = Integer.parseInt(str1[1]) + Integer.parseInt(str2[1]) + Integer.parseInt(str3[1]);
            int MayRanh = 151 - MayBan;
            jTextField2.setText("" + MayBan);
            jTextField1.setText("" + MayRanh);
        }
        }); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");
        setLocation(new java.awt.Point(400, 20));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ZONE 3 (Khu A) ");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("ZONE 1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("File");

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("ZONE 2 (Khoa CNTT) ");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("RUN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("STOP");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Check");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel5.setText("Máy rảnh: ");

        jLabel6.setText("Máy bận :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel2)
                .addGap(139, 139, 139)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tm.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tm.stop();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {                 
            Socket socket = serverSocket.accept();
            //Nhan IP cac may dang cap quyen
            dis = new DataInputStream(socket.getInputStream());
            String IP = dis.readUTF();
            jLabel7.setText("Máy có IP: " + IP + " được cấp quyền !!");
            
            //Gui lenh dieu khien den client
            dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF("Yeu cau gui anh!!");
            
            //Nhan anh tư client
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            BufferedImage bufferedImage = ImageIO.read(bufferedInputStream);                       
            ImageIO.write(bufferedImage, "jpg", new File("ImageFromClient.jpg"));
            
            bufferedInputStream.close();
            socket.close();                    
        } catch (Exception e) {
        }   
        pbl4_giamsatmanglan.Image f = new Image();
        f.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) throws IOException {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GiaoDien().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GiaoDien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    public String XuLyChuoi(Object str, String zone){
        int count = 0;
        String head = "Ten Lab         IP                        Trang thai\n";
        String[] t = str.toString().substring(1, str.toString().length() - 1).split(",");
        int i;
        int k = 0;  
        if(zone.equals("zone3"))
            head += "ĐTVT\n";
        else if(zone.equals("zone2"))
            head += "Phong 1\n";
        else
            head += "Thu vien\n";
        for(i = 1; i < t.length; i++){
            k++;
            if(zone.equals("zone2")){               
                if(i == 16){
                    k = 1;
                    head += "Phong 2\n";                
                }
                if(i == 31){
                    k = 1;
                    head += "Phong 3\n";                
                }
                if(i == 46){
                    k = 1;
                    head += "Phong 4\n";                
                }
                if(i == 61){
                    k = 1;
                    head += "Phong 5\n";                
                }
                if(i == 76){
                    k = 1;
                    head += "Phong 6\n";                
                }
                if(i == 91){
                    k = 1;
                    head += "Phong 7\n";                
                }
            }
            if(zone.equals("zone3")){               
                if(i == 11){
                    k = 1;
                    head += "HOA\n";                
                }
                if(i == 31){
                    k = 1;
                    head += "CO KHI\n";                
                }
            }            
            if(k < 10)
                head += ".....May" + k + "       ";
            else
                head += ".....May" + k + "     ";
            int KT = Integer.parseInt(t[i].substring(t[i].length()-1, t[i].length()));
            if(KT == 1)
                count++;
            String m = t[i].substring(0, t[i].length()-2);           
            if(m.length() == 12  && KT == 1)
                head += m.toString() + "          " + "online\n";
            else if(m.length() == 13  && KT == 1)
                head += m.toString() + "        " + "online\n";
            else if(m.length() == 14  && KT == 1)
                head += m.toString() + "      " + "online\n";
            else 
                head += "\n";
        }
        return head + "$" + count;
    }
    
    private ConcurrentSkipListSet scan(String firstIpInTheNetwork, int numOfIps) {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
         final String networkId = firstIpInTheNetwork.substring(0, firstIpInTheNetwork.length() - 1);
         ConcurrentSkipListSet ipsSet = new ConcurrentSkipListSet();
 
         AtomicInteger ips = new AtomicInteger(0);
         while (ips.get() <= numOfIps) {
             String ip = networkId + ips.getAndIncrement();
             executorService.submit(() -> {
                 try {
                     InetAddress inAddress = InetAddress.getByName(ip);
                     if (inAddress.isReachable(1000)) {
                         ipsSet.add(ip + ".1");
                     }
                     else
                         ipsSet.add(ip + ".0");
                 }
                 catch (IOException e) {
                 }
             });
         }
         executorService.shutdown();
         try {
             executorService.awaitTermination(1, TimeUnit.MINUTES);
         }
         catch (InterruptedException e) {
             System.out.println(e.getMessage());
         }
         return ipsSet;
     }
}

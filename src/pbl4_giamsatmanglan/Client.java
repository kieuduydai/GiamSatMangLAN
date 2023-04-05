package pbl4_giamsatmanglan;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Client {

    public static void main(String[] args) throws IOException, AWTException{
       Socket socket = new Socket("localhost", 8000);
        System.out.println("Connected to server.");
        
        JFrame jFrame = new JFrame("CLient");
        jFrame.setSize(500, 150);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
        
        //Thong tin ve may tinh
        InetAddress inet = InetAddress.getLocalHost();
        JTextArea text = new JTextArea();
        text.setText("Thông tin máy tính :\n    Tên máy:   " + inet.getHostName()+ "\n    Địa chỉ IP:  " + inet.getHostAddress());
        jFrame.add(text, BorderLayout.CENTER);
        
        //Lay anh man hinh
        Rectangle screRectangle = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capImage = new Robot().createScreenCapture(screRectangle);
        ImageIcon imgIco = new ImageIcon(capImage);
        java.awt.Image imFit2 = imgIco.getImage();
        
        ImageIcon imageIcon = new ImageIcon(imFit2);
        
        JButton jButton = new JButton("Cấp quyền");
        
        jFrame.add(jButton, BorderLayout.SOUTH);
        
        jFrame.setVisible(true);
        
        jButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Gui dia chi IP cua may cho server
                    InetAddress inet = InetAddress.getLocalHost();
                    String IP = inet.getHostAddress();
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(IP + "");
                    
                    //Nhan thong diep tu server
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String str = dis.readUTF();
                    if(str != null){
                        //Gui anh den sever
                    OutputStream outputStream = socket.getOutputStream();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
                    
                    java.awt.Image image = imageIcon.getImage();
                    
                    BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
                    
                    Graphics graphics = bufferedImage.createGraphics();
                    graphics.drawImage(image, 0, 0, null);
                    graphics.dispose();
                    
                    ImageIO.write(bufferedImage, "png", bufferedOutputStream);
                    
                    bufferedOutputStream.close();
                    socket.close();
                    }                                      
                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        });
    }
    
}

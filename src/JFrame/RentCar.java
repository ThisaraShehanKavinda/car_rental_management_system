/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class RentCar extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public RentCar() {
        initComponents();
        
        //roundForm
        
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,40));
        
        
        
        
        
                lblCustomerAddress.setText("");
                lblCustomerID.setText("");
                lblCustomerName.setText("");
                lblCustomerIDNO.setText("");
                lblCustomerContact.setText("");
                
                lblCarID.setText("");
                lblCarBrand.setText("");
                lblCarModel.setText("");
                
                lblcarError.setText("");
                lblcustomerError.setText("");
                
                lblTotalAmount.setText("");
    }

    
    //get Customer Details
    
    public void getCustomerDetails(){
        int customerID =Integer.parseInt( txtCustomerID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from customer where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,customerID);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lblCustomerID.setText(rs.getString("id"));
                lblCustomerName.setText(rs.getString("name"));
                lblCustomerIDNO.setText(rs.getString("iD_No"));
                lblCustomerContact.setText(rs.getString("contact"));
                lblCustomerAddress.setText(rs.getString("address"));
                 lblcustomerError.setText("");
            }else{
                lblcustomerError.setText("Invalid Customer ID");
                lblCustomerAddress.setText("");
                lblCustomerID.setText("");
                lblCustomerName.setText("");
                lblCustomerIDNO.setText("");
                lblCustomerContact.setText("");
                
            }
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    //get car details
     public void getCarDetails(){
        int carId =Integer.parseInt( txtCarID.getText());
        
    
    try {
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement("SELECT car_Photo FROM car WHERE id = ?");
        pst.setInt(1, carId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            byte[] imageData = rs.getBytes("car_Photo");
            Image image = ImageIO.read(new ByteArrayInputStream(imageData));
            Image scaledImage = image.getScaledInstance(lblCarImage.getWidth(), lblCarImage.getHeight(), Image.SCALE_SMOOTH);
            lblCarImage.setIcon(new ImageIcon(scaledImage));
        } else {
            lblCarImage.setIcon(null);
        }
        pst.close();
        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        
        
        
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from car where id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, carId);
            ResultSet rs = pst.executeQuery();
            
          if(rs.next()){
                lblCarID.setText(rs.getString("id"));
                lblCarBrand.setText(rs.getString("car_Brand"));
                lblCarModel.setText(rs.getString("car_Model"));
                
                lblcarError.setText("");
                
            }else{
              lblcarError.setText("Invalid Student ID");
              lblCarID.setText("");
              lblCarBrand.setText("");
              lblCarModel.setText("");
              lblCarImage.setIcon(null);
          }
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    //rent Car
     public boolean rentCar(){
        boolean isRent = false;
        
        int customerID = Integer.parseInt(txtCustomerID.getText());
        int carID = Integer.parseInt(txtCarID.getText());
        int totalAmount = Integer.parseInt(lblTotalAmount.getText());
        int noOfDays = Integer.parseInt(txtNoOfDays.getText());
        
        String customerName = lblCustomerName.getText();
        String carModel =lblCarModel.getText();
        
        
        Date fromDate = dateFrom.getDatoFecha();
        Date toDate = dateTo.getDatoFecha();
        
        Long l1 = fromDate.getTime();
        Long l2 = toDate.getTime();
        
        java.sql.Date sfromDate = new java.sql.Date(l1);
        java.sql.Date stoDate = new java.sql.Date(l2);
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into rent_car(customer_ID,customer_Name,car_ID,car_Model,from_Date,to_Date,no_of_days,charge,status) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, customerID);
            pst.setString(2, customerName);
            pst.setInt(3, carID);
            pst.setString(4, carModel);
            pst.setDate(5, sfromDate);
            pst.setDate(6, stoDate);
           pst.setInt(7, noOfDays);
            pst.setInt(8, totalAmount);
            pst.setString(9, "Pending");
            
            
           int rowCount  =  pst.executeUpdate();
           
           if(rowCount>0){
               isRent = true;
           }else{
               isRent = false;
           }
                    
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return isRent;
        
    }
    
    
    //calculate total Amount
     
     public void calcTotal(){
         int noOfDays = Integer.parseInt(txtNoOfDays.getText());
         int total = noOfDays*1500;
         
         lblTotalAmount.setText(String.valueOf(total));
         
         
         
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover4 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover5 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover6 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover7 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover8 = new rojeru_san.complementos.RSButtonHover();
        jPanel17 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        lblCarImage = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lblCarID = new javax.swing.JLabel();
        lblCarBrand = new javax.swing.JLabel();
        lblCarModel = new javax.swing.JLabel();
        lblcarError = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        lblCarPrice = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        txtCustomerID = new rojerusan.RSMetroTextPlaceHolder();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtCarID = new rojerusan.RSMetroTextPlaceHolder();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle8 = new rojerusan.RSMaterialButtonRectangle();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txtNoOfDays = new rojerusan.RSMetroTextPlaceHolder();
        dateTo = new rojeru_san.componentes.RSDateChooser();
        dateFrom = new rojeru_san.componentes.RSDateChooser();
        lblTotalAmount = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblCustomerIDNO = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lblCustomerContact = new javax.swing.JLabel();
        lblCustomerAddress = new javax.swing.JLabel();
        lblcustomerError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel2.setkStartColor(new java.awt.Color(102, 0, 102));
        kGradientPanel2.setLayout(null);

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home (1).png"))); // NOI18N
        kGradientPanel2.add(jLabel43);
        jLabel43.setBounds(10, 0, 32, 40);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-car (1).png"))); // NOI18N
        kGradientPanel2.add(jLabel47);
        jLabel47.setBounds(10, 40, 32, 40);

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer-review.png"))); // NOI18N
        kGradientPanel2.add(jLabel51);
        jLabel51.setBounds(10, 80, 32, 40);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car-rental.png"))); // NOI18N
        kGradientPanel2.add(jLabel52);
        jLabel52.setBounds(10, 120, 32, 40);

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        kGradientPanel2.add(jLabel53);
        jLabel53.setBounds(10, 160, 32, 40);

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analysis.png"))); // NOI18N
        kGradientPanel2.add(jLabel60);
        jLabel60.setBounds(10, 200, 32, 40);

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        kGradientPanel2.add(jLabel62);
        jLabel62.setBounds(10, 430, 32, 40);

        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power-on.png"))); // NOI18N
        kGradientPanel2.add(jLabel63);
        jLabel63.setBounds(10, 470, 32, 40);

        rSButtonHover1.setBackground(new java.awt.Color(51, 0, 51));
        rSButtonHover1.setText("EXIT");
        rSButtonHover1.setColorHover(new java.awt.Color(153, 0, 0));
        rSButtonHover1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover1ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonHover1);
        rSButtonHover1.setBounds(0, 470, 250, 40);

        rSButtonHover2.setBackground(new java.awt.Color(51, 0, 51));
        rSButtonHover2.setText("HOME");
        rSButtonHover2.setColorHover(new java.awt.Color(0, 0, 102));
        rSButtonHover2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover2ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonHover2);
        rSButtonHover2.setBounds(0, 0, 250, 40);

        rSButtonHover3.setBackground(new java.awt.Color(51, 0, 51));
        rSButtonHover3.setText("CARS");
        rSButtonHover3.setColorHover(new java.awt.Color(0, 0, 102));
        rSButtonHover3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover3ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonHover3);
        rSButtonHover3.setBounds(0, 40, 250, 40);

        rSButtonHover4.setBackground(new java.awt.Color(51, 0, 51));
        rSButtonHover4.setText("CUSTOMERS");
        rSButtonHover4.setColorHover(new java.awt.Color(0, 0, 102));
        rSButtonHover4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover4ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonHover4);
        rSButtonHover4.setBounds(0, 80, 250, 40);

        rSButtonHover5.setBackground(new java.awt.Color(153, 0, 153));
        rSButtonHover5.setText("RENT CAR");
        rSButtonHover5.setColorHover(new java.awt.Color(153, 0, 153));
        rSButtonHover5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover5ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonHover5);
        rSButtonHover5.setBounds(0, 120, 250, 40);

        rSButtonHover6.setBackground(new java.awt.Color(51, 0, 51));
        rSButtonHover6.setText("RETURN CAR");
        rSButtonHover6.setColorHover(new java.awt.Color(0, 0, 102));
        rSButtonHover6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover6ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonHover6);
        rSButtonHover6.setBounds(0, 160, 250, 40);

        rSButtonHover7.setBackground(new java.awt.Color(51, 0, 51));
        rSButtonHover7.setText("DASHBOARD");
        rSButtonHover7.setColorHover(new java.awt.Color(0, 0, 102));
        rSButtonHover7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover7ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonHover7);
        rSButtonHover7.setBounds(0, 200, 250, 40);

        rSButtonHover8.setBackground(new java.awt.Color(51, 0, 51));
        rSButtonHover8.setText("LOGOUT");
        rSButtonHover8.setColorHover(new java.awt.Color(153, 51, 0));
        rSButtonHover8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonHover8ActionPerformed(evt);
            }
        });
        kGradientPanel2.add(rSButtonHover8);
        rSButtonHover8.setBounds(0, 430, 250, 40);

        jPanel1.add(kGradientPanel2);
        kGradientPanel2.setBounds(0, 0, 250, 510);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 50, 250, 510);

        jPanel17.setBackground(new java.awt.Color(0,0,0,180));

        jLabel48.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel48.setText("ID             :");

        jLabel49.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel49.setText("Brand      :");

        jLabel50.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel50.setText("Photo       :");

        jLabel54.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel54.setText("Model      :");

        lblCarImage.setBackground(new java.awt.Color(255, 255, 255));
        lblCarImage.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblCarImage.setForeground(new java.awt.Color(255, 255, 255));
        lblCarImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car.png"))); // NOI18N
        lblCarImage.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 102)));

        jLabel31.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("CAR");

        jLabel33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-car (2).png"))); // NOI18N

        lblCarID.setBackground(new java.awt.Color(255, 255, 255));
        lblCarID.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCarID.setForeground(new java.awt.Color(51, 0, 51));
        lblCarID.setText("01");
        lblCarID.setOpaque(true);

        lblCarBrand.setBackground(new java.awt.Color(255, 255, 255));
        lblCarBrand.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCarBrand.setForeground(new java.awt.Color(51, 0, 51));
        lblCarBrand.setText("BMW");
        lblCarBrand.setOpaque(true);

        lblCarModel.setBackground(new java.awt.Color(255, 255, 255));
        lblCarModel.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCarModel.setForeground(new java.awt.Color(51, 0, 51));
        lblCarModel.setText("Las02");
        lblCarModel.setOpaque(true);

        lblcarError.setBackground(new java.awt.Color(0, 0, 0));
        lblcarError.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblcarError.setForeground(new java.awt.Color(255, 255, 255));
        lblcarError.setText("Invalid");
        lblcarError.setOpaque(true);

        jLabel64.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel64.setText("Price        :");

        lblCarPrice.setBackground(new java.awt.Color(255, 255, 255));
        lblCarPrice.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCarPrice.setForeground(new java.awt.Color(51, 0, 51));
        lblCarPrice.setText("230000");
        lblCarPrice.setOpaque(true);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCarBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCarID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblCarImage, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(18, 18, 18)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(lblcarError, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCarPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarModel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCarPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCarImage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblcarError, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        getContentPane().add(jPanel17);
        jPanel17.setBounds(570, 60, 290, 490);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/burger-menu.png"))); // NOI18N
        jLabel2.setAlignmentY(0.0F);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(6, 6, 24, 24);

        jPanel4.setBackground(new java.awt.Color(153, 0, 153));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(40, 7, 4, 35);

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sport-car (1).png"))); // NOI18N
        jPanel2.add(jLabel26);
        jLabel26.setBounds(240, 0, 43, 50);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 0, 102));
        kGradientPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 204));
        jLabel4.setText("THISARA'S CAR RENTAL SERVICE");
        jLabel4.setAlignmentY(0.0F);
        kGradientPanel1.add(jLabel4);
        jLabel4.setBounds(290, 10, 360, 26);

        jPanel2.add(kGradientPanel1);
        kGradientPanel1.setBounds(0, 0, 1270, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1270, 50);

        jPanel18.setBackground(new java.awt.Color(0,0,0,180));

        txtCustomerID.setForeground(new java.awt.Color(153, 0, 153));
        txtCustomerID.setBorderColor(new java.awt.Color(153, 0, 153));
        txtCustomerID.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCustomerID.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCustomerID.setPhColor(new java.awt.Color(204, 0, 204));
        txtCustomerID.setPlaceholder("Enter Customer ID..");
        txtCustomerID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustomerIDFocusLost(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel55.setText("Custmer  ID    :");

        jLabel56.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel56.setText("Car ID             :");

        jLabel57.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel57.setText("To                    :");

        jLabel58.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel58.setText("No of Days      :");

        txtCarID.setForeground(new java.awt.Color(153, 0, 153));
        txtCarID.setBorderColor(new java.awt.Color(153, 0, 153));
        txtCarID.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCarID.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCarID.setPhColor(new java.awt.Color(204, 0, 204));
        txtCarID.setPlaceholder("Enter Car ID..");
        txtCarID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCarIDFocusLost(evt);
            }
        });

        rSMaterialButtonRectangle7.setBackground(new java.awt.Color(0, 0, 153));
        rSMaterialButtonRectangle7.setText("rent");
        rSMaterialButtonRectangle7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle7MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle8.setBackground(new java.awt.Color(102, 0, 51));
        rSMaterialButtonRectangle8.setText("Calculate Charge");
        rSMaterialButtonRectangle8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle8MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle8ActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel59.setText("Total Amount   :");

        jLabel61.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel61.setText("From               :");

        txtNoOfDays.setForeground(new java.awt.Color(153, 0, 153));
        txtNoOfDays.setBorderColor(new java.awt.Color(153, 0, 153));
        txtNoOfDays.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNoOfDays.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtNoOfDays.setPhColor(new java.awt.Color(204, 0, 204));
        txtNoOfDays.setPlaceholder("Enter No days..");

        dateTo.setForeground(new java.awt.Color(153, 153, 153));
        dateTo.setColorBackground(new java.awt.Color(153, 0, 153));
        dateTo.setColorForeground(new java.awt.Color(51, 0, 51));
        dateTo.setPlaceholder("Select Ending Date");

        dateFrom.setForeground(new java.awt.Color(51, 0, 51));
        dateFrom.setColorBackground(new java.awt.Color(153, 0, 153));
        dateFrom.setColorForeground(new java.awt.Color(51, 0, 51));
        dateFrom.setPlaceholder("Select Starting Date");

        lblTotalAmount.setBackground(new java.awt.Color(0, 0, 0));
        lblTotalAmount.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblTotalAmount.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalAmount.setText("200000.00");
        lblTotalAmount.setOpaque(true);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(txtCarID, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNoOfDays, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCarID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoOfDays, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel18);
        jPanel18.setBounds(870, 60, 390, 490);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(null);

        jPanel16.setBackground(new java.awt.Color(0,0,0,180));

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel41.setText("ID             :");

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel42.setText("Name       :");

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel44.setText("ID No        :");

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel45.setText("Contact    :");

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel46.setText("Address   :");

        jLabel29.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("CUSTOMER");

        jLabel32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile (3).png"))); // NOI18N

        lblCustomerIDNO.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerIDNO.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCustomerIDNO.setForeground(new java.awt.Color(51, 0, 51));
        lblCustomerIDNO.setText("2000827398v");
        lblCustomerIDNO.setOpaque(true);

        lblCustomerID.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerID.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCustomerID.setForeground(new java.awt.Color(51, 0, 51));
        lblCustomerID.setText("01");
        lblCustomerID.setOpaque(true);

        lblCustomerName.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerName.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCustomerName.setForeground(new java.awt.Color(51, 0, 51));
        lblCustomerName.setText("Thisara");
        lblCustomerName.setOpaque(true);

        lblCustomerContact.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerContact.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCustomerContact.setForeground(new java.awt.Color(51, 0, 51));
        lblCustomerContact.setText("07636536253");
        lblCustomerContact.setOpaque(true);

        lblCustomerAddress.setBackground(new java.awt.Color(255, 255, 255));
        lblCustomerAddress.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblCustomerAddress.setForeground(new java.awt.Color(51, 0, 51));
        lblCustomerAddress.setText("Kegalle");
        lblCustomerAddress.setOpaque(true);

        lblcustomerError.setBackground(new java.awt.Color(0, 0, 0));
        lblcustomerError.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        lblcustomerError.setForeground(new java.awt.Color(255, 255, 255));
        lblcustomerError.setText("Invalid");
        lblcustomerError.setOpaque(true);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCustomerContact, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCustomerIDNO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(lblcustomerError, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerIDNO, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerContact, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCustomerAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96)
                .addComponent(lblcustomerError, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel16);
        jPanel16.setBounds(10, 10, 290, 490);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpaperflare.com_wallpaper (5).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1061, 510);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(250, 50, 1020, 510);

        setSize(new java.awt.Dimension(1268, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle7MouseClicked

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
         if(rentCar()==true){
            JOptionPane.showMessageDialog(this, "Car Rent Successfully");
            
        }else{
            JOptionPane.showMessageDialog(this, "Car Rent Fail");
        
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed

    private void rSMaterialButtonRectangle8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle8MouseClicked

    private void rSMaterialButtonRectangle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle8ActionPerformed
       calcTotal();
    }//GEN-LAST:event_rSMaterialButtonRectangle8ActionPerformed

    private void txtCustomerIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerIDFocusLost
        if(!txtCustomerID.getText().equals("")){
             getCustomerDetails();
        }
    }//GEN-LAST:event_txtCustomerIDFocusLost

    private void txtCarIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCarIDFocusLost
         if(!txtCarID.getText().equals(""));
             getCarDetails();
    }//GEN-LAST:event_txtCarIDFocusLost

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

    private void rSButtonHover2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover2ActionPerformed
        HomePage hp = new HomePage();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonHover2ActionPerformed

    private void rSButtonHover3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover3ActionPerformed
        Cars cars = new Cars();
        cars.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonHover3ActionPerformed

    private void rSButtonHover4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover4ActionPerformed
        Customers customers = new Customers();
        customers.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonHover4ActionPerformed

    private void rSButtonHover5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover5ActionPerformed
        RentCar rentcar = new RentCar();
        rentcar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonHover5ActionPerformed

    private void rSButtonHover6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover6ActionPerformed
        ReturnCar returnc = new ReturnCar();
        returnc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonHover6ActionPerformed

    private void rSButtonHover7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover7ActionPerformed
        DashBoard db = new DashBoard();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonHover7ActionPerformed

    private void rSButtonHover8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover8ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonHover8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RentCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RentCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RentCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RentCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser dateFrom;
    private rojeru_san.componentes.RSDateChooser dateTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblCarBrand;
    private javax.swing.JLabel lblCarID;
    private javax.swing.JLabel lblCarImage;
    private javax.swing.JLabel lblCarModel;
    private javax.swing.JLabel lblCarPrice;
    private javax.swing.JLabel lblCustomerAddress;
    private javax.swing.JLabel lblCustomerContact;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerIDNO;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblcarError;
    private javax.swing.JLabel lblcustomerError;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.complementos.RSButtonHover rSButtonHover4;
    private rojeru_san.complementos.RSButtonHover rSButtonHover5;
    private rojeru_san.complementos.RSButtonHover rSButtonHover6;
    private rojeru_san.complementos.RSButtonHover rSButtonHover7;
    private rojeru_san.complementos.RSButtonHover rSButtonHover8;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle8;
    private rojerusan.RSMetroTextPlaceHolder txtCarID;
    private rojerusan.RSMetroTextPlaceHolder txtCustomerID;
    private rojerusan.RSMetroTextPlaceHolder txtNoOfDays;
    // End of variables declaration//GEN-END:variables
}

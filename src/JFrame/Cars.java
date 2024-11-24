/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class Cars extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    
    String carNo,carBrand,carModel,carType;
    int carID;
    DefaultTableModel model;
    String path2 =null;
    
    
    public Cars() {
        initComponents();
        setCarDetailsIntoTable();
        //roundForm
        
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,40));
    }

    //clear Table
    
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tblCar.getModel();
        model.setRowCount(0);
    }
    
    //setValues to table
     public void setCarDetailsIntoTable(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/car_rental_ms","root","");
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from car");
            
            while(rs.next()){
                String carid = rs.getString("id");
                String carno = rs.getString("car_No");
                String carbrand = rs.getString("car_Brand");
                String carmodel = rs.getString("car_Model");
                String cartype = rs.getString("car_Type");
                String carphoto = rs.getString("car_Photo");
                
                Object[] obj = {carid,carno,carbrand,carmodel,cartype,carphoto};
                model =(DefaultTableModel) tblCar.getModel();
                model.addRow(obj);
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //add car
      public boolean addCar(){
        
        boolean isAdded = false;
        
        carID = Integer.parseInt(txtCarID.getText());
        carNo = txtCarNo.getText();
        carBrand = txtBrand.getText();
        carModel = txtModel.getText();
        carType = cmbCarType.getSelectedItem().toString();
        
        
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into car values(?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1,carID);
            pst.setString(2, carNo);
            pst.setString(3, carBrand);
            pst.setString(4, carModel);
            pst.setString(5,carType);
            InputStream is = new FileInputStream(new File(path2));
            
            pst.setBlob(6, is);
            
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                isAdded = true;
            }
            else{
                isAdded =false;
            }
            
            txtCarID.setText("");
            txtCarNo.setText("");
            txtBrand.setText("");
            txtModel.setText("");
            cmbCarType.setSelectedItem("");
            lblPhoto.setIcon(null);
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return isAdded;
    }
    
   
      //update Car
       public boolean updateCar(){
        
        boolean isAdded = false;
        carID = Integer.parseInt(txtCarID.getText());
        carNo = txtCarNo.getText();
        carBrand = txtBrand.getText();
        carModel = txtModel.getText();
        carType = cmbCarType.getSelectedItem().toString();
       
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = ("update car set car_No= ?,car_Brand =?,car_Model=?,car_Type=?,car_Photo=? where id = ?");
            PreparedStatement pst = con.prepareStatement(sql);
            
            
            pst.setString(1, carNo);
            pst.setString(2, carBrand);
            pst.setString(3, carModel);
            pst.setString(4,carType);
            InputStream is = new FileInputStream(new File(path2));
            
            pst.setBlob(5, is);
            pst.setInt(6,carID);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                isAdded = true;
            }
            else{
                isAdded =false;
            }
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isAdded;
    }
      
      //delete car
       public boolean deleteCar(){
        boolean isAdded = false;
        carID = Integer.parseInt(txtCarID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = ("delete from car where id = ?");
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1,carID);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                isAdded = true;
            }
            else{
                isAdded =false;
            }
            
            
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
        return isAdded;
        
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rSButtonHover1 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover2 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover3 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover4 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover5 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover6 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover7 = new rojeru_san.complementos.RSButtonHover();
        rSButtonHover8 = new rojeru_san.complementos.RSButtonHover();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        cmbCarType = new javax.swing.JComboBox<>();
        lblPhoto = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtModel = new rojerusan.RSMetroTextPlaceHolder();
        txtCarID = new rojerusan.RSMetroTextPlaceHolder();
        txtCarNo = new rojerusan.RSMetroTextPlaceHolder();
        txtBrand = new rojerusan.RSMetroTextPlaceHolder();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCar = new rojeru_san.complementos.RSTableMetro();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle1 = new rojerusan.RSMaterialButtonRectangle();
        jLabel47 = new javax.swing.JLabel();
        txtPrice = new rojerusan.RSMetroTextPlaceHolder();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        kGradientPanel2.setkEndColor(new java.awt.Color(0, 0, 0));
        kGradientPanel2.setkStartColor(new java.awt.Color(102, 0, 102));
        kGradientPanel2.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home (1).png"))); // NOI18N
        kGradientPanel2.add(jLabel5);
        jLabel5.setBounds(10, 0, 32, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-car (1).png"))); // NOI18N
        kGradientPanel2.add(jLabel6);
        jLabel6.setBounds(10, 40, 32, 40);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/customer-review.png"))); // NOI18N
        kGradientPanel2.add(jLabel7);
        jLabel7.setBounds(10, 80, 32, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car-rental.png"))); // NOI18N
        kGradientPanel2.add(jLabel8);
        jLabel8.setBounds(10, 120, 32, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/return.png"))); // NOI18N
        kGradientPanel2.add(jLabel9);
        jLabel9.setBounds(10, 160, 32, 40);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/analysis.png"))); // NOI18N
        kGradientPanel2.add(jLabel10);
        jLabel10.setBounds(10, 200, 32, 40);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        kGradientPanel2.add(jLabel11);
        jLabel11.setBounds(10, 430, 32, 40);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power-on.png"))); // NOI18N
        kGradientPanel2.add(jLabel12);
        jLabel12.setBounds(10, 470, 32, 40);

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

        rSButtonHover3.setBackground(new java.awt.Color(153, 0, 153));
        rSButtonHover3.setText("CARS");
        rSButtonHover3.setColorHover(new java.awt.Color(153, 0, 153));
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

        rSButtonHover5.setBackground(new java.awt.Color(51, 0, 51));
        rSButtonHover5.setText("RENT CAR");
        rSButtonHover5.setColorHover(new java.awt.Color(0, 0, 102));
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

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(null);

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

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 204));
        jLabel3.setText("THISARA'S CAR RENTAL SERVICE");
        jLabel3.setAlignmentY(0.0F);
        kGradientPanel1.add(jLabel3);
        jLabel3.setBounds(290, 10, 370, 26);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 204));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/burger-menu.png"))); // NOI18N
        jLabel2.setAlignmentY(0.0F);
        kGradientPanel1.add(jLabel2);
        jLabel2.setBounds(10, 10, 24, 24);

        jPanel2.add(kGradientPanel1);
        kGradientPanel1.setBounds(0, 0, 1270, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1270, 50);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(null);

        jPanel16.setBackground(new java.awt.Color(0, 0, 0,150));
        jPanel16.setLayout(null);

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel41.setText("Car No       :");
        jPanel16.add(jLabel41);
        jLabel41.setBounds(6, 91, 120, 29);

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel42.setText("Car Brand :");
        jPanel16.add(jLabel42);
        jLabel42.setBounds(6, 146, 120, 29);

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel43.setText("Price per Day :");
        jPanel16.add(jLabel43);
        jLabel43.setBounds(420, 50, 140, 29);

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel44.setText("Car Photo :");
        jPanel16.add(jLabel44);
        jLabel44.setBounds(420, 100, 120, 29);

        cmbCarType.setBackground(new java.awt.Color(51, 51, 51));
        cmbCarType.setEditable(true);
        cmbCarType.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cmbCarType.setForeground(new java.awt.Color(51, 0, 51));
        cmbCarType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Economy cars", "Compact cars", "Compact cars", "Luxury cars", " " }));
        cmbCarType.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));
        jPanel16.add(cmbCarType);
        cmbCarType.setBounds(132, 240, 250, 35);

        lblPhoto.setBackground(new java.awt.Color(255, 255, 255));
        lblPhoto.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPhoto.setForeground(new java.awt.Color(255, 255, 255));
        lblPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/car.png"))); // NOI18N
        lblPhoto.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 0, 102)));
        jPanel16.add(lblPhoto);
        lblPhoto.setBounds(570, 90, 195, 140);

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel45.setText("Car Model :");
        jPanel16.add(jLabel45);
        jLabel45.setBounds(6, 193, 120, 29);

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel46.setText("Car ID        :");
        jPanel16.add(jLabel46);
        jLabel46.setBounds(6, 36, 120, 29);

        txtModel.setForeground(new java.awt.Color(51, 0, 51));
        txtModel.setText("Enter Car Model");
        txtModel.setBorderColor(new java.awt.Color(102, 0, 102));
        txtModel.setBotonColor(new java.awt.Color(102, 0, 102));
        txtModel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtModel.setPhColor(new java.awt.Color(102, 0, 102));
        txtModel.setSelectedTextColor(new java.awt.Color(102, 0, 102));
        jPanel16.add(txtModel);
        txtModel.setBounds(130, 190, 250, 40);

        txtCarID.setForeground(new java.awt.Color(51, 0, 51));
        txtCarID.setText("Enter Car ID");
        txtCarID.setBorderColor(new java.awt.Color(102, 0, 102));
        txtCarID.setBotonColor(new java.awt.Color(102, 0, 102));
        txtCarID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCarID.setPhColor(new java.awt.Color(102, 0, 102));
        txtCarID.setSelectedTextColor(new java.awt.Color(102, 0, 102));
        jPanel16.add(txtCarID);
        txtCarID.setBounds(130, 40, 250, 40);

        txtCarNo.setForeground(new java.awt.Color(51, 0, 51));
        txtCarNo.setText("Enter Car No");
        txtCarNo.setBorderColor(new java.awt.Color(102, 0, 102));
        txtCarNo.setBotonColor(new java.awt.Color(102, 0, 102));
        txtCarNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCarNo.setPhColor(new java.awt.Color(102, 0, 102));
        txtCarNo.setSelectedTextColor(new java.awt.Color(102, 0, 102));
        jPanel16.add(txtCarNo);
        txtCarNo.setBounds(130, 90, 250, 40);

        txtBrand.setForeground(new java.awt.Color(51, 0, 51));
        txtBrand.setText("Enter Car Brand");
        txtBrand.setBorderColor(new java.awt.Color(102, 0, 102));
        txtBrand.setBotonColor(new java.awt.Color(102, 0, 102));
        txtBrand.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtBrand.setPhColor(new java.awt.Color(102, 0, 102));
        txtBrand.setSelectedTextColor(new java.awt.Color(102, 0, 102));
        jPanel16.add(txtBrand);
        txtBrand.setBounds(130, 140, 250, 40);

        tblCar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Car No", "Brand", "Model", "Type", "Photo"
            }
        ));
        tblCar.setColorBackgoundHead(new java.awt.Color(102, 0, 102));
        tblCar.setColorFilasForeground1(new java.awt.Color(102, 0, 102));
        tblCar.setColorFilasForeground2(new java.awt.Color(102, 0, 102));
        tblCar.setColorSelBackgound(new java.awt.Color(102, 0, 102));
        tblCar.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblCar.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblCar.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblCar.setGridColor(new java.awt.Color(102, 0, 102));
        tblCar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCar);

        jPanel16.add(jScrollPane1);
        jScrollPane1.setBounds(80, 310, 860, 170);

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(102, 0, 0));
        rSMaterialButtonRectangle4.setText("DELETE");
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });
        jPanel16.add(rSMaterialButtonRectangle4);
        rSMaterialButtonRectangle4.setBounds(850, 220, 140, 50);

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(0, 0, 102));
        rSMaterialButtonRectangle2.setText("ADD");
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });
        jPanel16.add(rSMaterialButtonRectangle2);
        rSMaterialButtonRectangle2.setBounds(850, 90, 140, 50);

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(51, 0, 51));
        rSMaterialButtonRectangle3.setText("Update");
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });
        jPanel16.add(rSMaterialButtonRectangle3);
        rSMaterialButtonRectangle3.setBounds(850, 150, 140, 50);

        rSMaterialButtonRectangle1.setBackground(new java.awt.Color(0, 51, 51));
        rSMaterialButtonRectangle1.setText("UPLOAD");
        rSMaterialButtonRectangle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle1ActionPerformed(evt);
            }
        });
        jPanel16.add(rSMaterialButtonRectangle1);
        rSMaterialButtonRectangle1.setBounds(600, 240, 140, 50);

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel47.setText("Car Type   :");
        jPanel16.add(jLabel47);
        jLabel47.setBounds(6, 242, 120, 29);

        txtPrice.setForeground(new java.awt.Color(51, 0, 51));
        txtPrice.setText("Enter Price Per Day");
        txtPrice.setBorderColor(new java.awt.Color(102, 0, 102));
        txtPrice.setBotonColor(new java.awt.Color(102, 0, 102));
        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPrice.setPhColor(new java.awt.Color(102, 0, 102));
        txtPrice.setSelectedTextColor(new java.awt.Color(102, 0, 102));
        jPanel16.add(txtPrice);
        txtPrice.setBounds(570, 40, 250, 40);

        jPanel3.add(jPanel16);
        jPanel16.setBounds(10, 10, 1000, 490);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpaperflare.com_wallpaper (5).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1020, 510);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(250, 50, 1020, 510);

        setSize(new java.awt.Dimension(1268, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1MouseClicked
     
    }//GEN-LAST:event_rSMaterialButtonRectangle1MouseClicked

    private void rSMaterialButtonRectangle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle1ActionPerformed
    JFileChooser chooser =  new JFileChooser();
    chooser.showOpenDialog(null);
    File f = chooser.getSelectedFile();
    String path = f.getAbsolutePath();
    
        try {
            BufferedImage bi = ImageIO.read(new File(path));
            Image img = bi.getScaledInstance(189, 140, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblPhoto.setIcon(icon);
            path2 = path;
        } catch (IOException ex) {
            Logger.getLogger(Cars.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    
    
    }//GEN-LAST:event_rSMaterialButtonRectangle1ActionPerformed

    private void rSMaterialButtonRectangle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle2MouseClicked

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
           if(addCar()== true){
            JOptionPane.showMessageDialog(this, "Data inserted Successfully");
            clearTable();
            setCarDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data insert fail");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void rSMaterialButtonRectangle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3MouseClicked

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
        if(updateCar()== true){
            JOptionPane.showMessageDialog(this, "Data updated Successfully");
            clearTable();
            setCarDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data update fail");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void rSMaterialButtonRectangle4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4MouseClicked

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
           if(deleteCar()== true){
            JOptionPane.showMessageDialog(this, "Data deleted Successfully");
            clearTable();
            setCarDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data delete fail");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void rSButtonPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonPane1MouseClicked
        HomePage hp = new HomePage();
        hp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonPane1MouseClicked

    private void rSButtonPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonPane3MouseClicked
        Customers cus = new Customers();
        cus.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonPane3MouseClicked

    private void rSButtonPane4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonPane4MouseClicked
       RentCar rent = new RentCar();
        rent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonPane4MouseClicked

    private void rSButtonPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonPane5MouseClicked
        ReturnCar ret = new ReturnCar();
        ret.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonPane5MouseClicked

    private void rSButtonPane7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonPane7MouseClicked
       DashBoard db = new DashBoard();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonPane7MouseClicked

    private void rSButtonPane6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonPane6MouseClicked
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButtonPane6MouseClicked

    private void rSButtonPane8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonPane8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_rSButtonPane8MouseClicked

    private void tblCarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCarMouseClicked
         int rowNo = tblCar.getSelectedRow();
        TableModel model = tblCar.getModel();
        
        txtCarID.setText(model.getValueAt(rowNo,0).toString());
        txtCarNo.setText(model.getValueAt(rowNo,1).toString());
        txtBrand.setText(model.getValueAt(rowNo,2).toString());
        txtModel.setText(model.getValueAt(rowNo,3).toString());
        cmbCarType.setSelectedItem(model.getValueAt(rowNo,4).toString());
        
        try {
        Connection con = DBConnection.getConnection();
        PreparedStatement pstmt = con.prepareStatement("SELECT car_Photo FROM car WHERE id = ?");
        pstmt.setInt(1, Integer.parseInt(model.getValueAt(rowNo, 0).toString()));
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            byte[] imageData = rs.getBytes("car_Photo");
            Image image = ImageIO.read(new ByteArrayInputStream(imageData));
            Image scaledImage = image.getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(), Image.SCALE_SMOOTH);
            lblPhoto.setIcon(new ImageIcon(scaledImage));
        }
        con.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
        
     /*   String path = "C:\\Users\\PC\\Documents\\NetBeansProjects\\CarRentalManagementSystem\\src\\images\\img.jpg";
        byte[] bytea = image.getByte(1,(int)image.Length());
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(bytea);
        ImageIcon icon = new ImageIcon(bytea);
        lblPhoto.setIcon(icon);*/
        
        
        
    }//GEN-LAST:event_tblCarMouseClicked

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

    private void rSButtonHover1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonHover1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_rSButtonHover1ActionPerformed

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
            java.util.logging.Logger.getLogger(Cars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cars().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCarType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel2;
    private javax.swing.JLabel lblPhoto;
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.complementos.RSButtonHover rSButtonHover4;
    private rojeru_san.complementos.RSButtonHover rSButtonHover5;
    private rojeru_san.complementos.RSButtonHover rSButtonHover6;
    private rojeru_san.complementos.RSButtonHover rSButtonHover7;
    private rojeru_san.complementos.RSButtonHover rSButtonHover8;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle1;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojeru_san.complementos.RSTableMetro tblCar;
    private rojerusan.RSMetroTextPlaceHolder txtBrand;
    private rojerusan.RSMetroTextPlaceHolder txtCarID;
    private rojerusan.RSMetroTextPlaceHolder txtCarNo;
    private rojerusan.RSMetroTextPlaceHolder txtModel;
    private rojerusan.RSMetroTextPlaceHolder txtPrice;
    // End of variables declaration//GEN-END:variables
}

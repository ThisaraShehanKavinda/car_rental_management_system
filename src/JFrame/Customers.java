/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author PC
 */
public class Customers extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public Customers() {
        initComponents();
        setCustomerDetailsIntoTable();
        
        
        //roundForm
        
        setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,40));
        
    }

    
    String customerName,iDType,iDNo,contact,address;
    int customerID,age;
    DefaultTableModel model;
    
    
    //method to clear Table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel)tblCustomer.getModel();
        model.setRowCount(0);
    }
    
    
    
    
    
    //set customer details into table
    public void setCustomerDetailsIntoTable(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/car_rental_ms","root","");
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from customer");
            
            while(rs.next()){
                String customerId = rs.getString("id");
                String Name = rs.getString("name");
                String age1 = rs.getString("age");
                String idType = rs.getString("id_Type");
                String idNo= rs.getString("iD_No");
                String contact1 = rs.getString("contact");
                String address1 = rs.getString("address");
                
                Object[] obj = {customerId,Name,age1,idType,idNo,contact1,address1};
                model =(DefaultTableModel) tblCustomer.getModel();
                model.addRow(obj);
            }
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //add new customer
    public boolean addCustomer(){
        
        boolean isAdded = false;
        
        customerID = Integer.parseInt(txtCustomerID.getText());
        customerName = txtName.getText();
        age = Integer.parseInt(txtAge.getText());
        iDType = cmbIDType.getSelectedItem().toString();
        iDNo = txtCustomeridNo.getText();
        contact = txtContact.getText();
        address = txtAddress.getText();
       
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into customer values(?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1,customerID);
            pst.setString(2, customerName);
            pst.setInt(3,age);
            pst.setString(4, iDType);
            pst.setString(5,iDNo);
            pst.setString(6,contact);
            pst.setString(7,address);
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount>0){
                isAdded = true;
            }
            else{
                isAdded =false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return isAdded;
    }
    
    //Update Customer
     public boolean updateCustomer(){
        
        boolean isAdded = false;
       customerID = Integer.parseInt(txtCustomerID.getText());
        customerName = txtName.getText();
        age = Integer.parseInt(txtAge.getText());
        iDType = cmbIDType.getSelectedItem().toString();
        iDNo = txtCustomeridNo.getText();
        contact = txtContact.getText();
        address = txtAddress.getText();
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = ("update customer set name= ?,age=?,id_Type=?,iD_No=?,contact=?,address=? where id = ?");
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setString(1, customerName);
            pst.setInt(2,age);
            pst.setString(3, iDType);
            pst.setString(4,iDNo);
            pst.setString(5,contact);
            pst.setString(6,address);
            pst.setInt(7,customerID);
            
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
    
    
     //delete customer
      public boolean deleteCustomer(){
        boolean isAdded = false;
        customerID = Integer.parseInt(txtCustomerID.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = ("delete from customer where id = ?");
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1,customerID);
            
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
        jLabel29 = new javax.swing.JLabel();
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
        txtCustomerID = new rojerusan.RSMetroTextPlaceHolder();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtName = new rojerusan.RSMetroTextPlaceHolder();
        rSMaterialButtonRectangle2 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle3 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle4 = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomer = new rojeru_san.complementos.RSTableMetro();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        txtAge = new rojerusan.RSMetroTextPlaceHolder();
        txtCustomeridNo = new rojerusan.RSMetroTextPlaceHolder();
        txtContact = new rojerusan.RSMetroTextPlaceHolder();
        txtAddress = new rojerusan.RSMetroTextPlaceHolder();
        cmbIDType = new javax.swing.JComboBox<>();
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

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power-on.png"))); // NOI18N
        kGradientPanel2.add(jLabel29);
        jLabel29.setBounds(10, 470, 32, 40);

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

        rSButtonHover4.setBackground(new java.awt.Color(153, 0, 153));
        rSButtonHover4.setText("CUSTOMERS");
        rSButtonHover4.setColorHover(new java.awt.Color(153, 0, 153));
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
        jLabel3.setBounds(290, 10, 360, 26);

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

        jPanel16.setBackground(new java.awt.Color(0,0,0,180));

        txtCustomerID.setForeground(new java.awt.Color(153, 0, 153));
        txtCustomerID.setBorderColor(new java.awt.Color(153, 0, 153));
        txtCustomerID.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCustomerID.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCustomerID.setPhColor(new java.awt.Color(204, 0, 204));
        txtCustomerID.setPlaceholder("Enter ID..");

        jLabel41.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel41.setText("ID             :");

        jLabel42.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel42.setText("Name       :");

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel43.setText("ID Type    :");

        jLabel44.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel44.setText("ID No        :");

        txtName.setForeground(new java.awt.Color(153, 0, 153));
        txtName.setBorderColor(new java.awt.Color(153, 0, 153));
        txtName.setCaretColor(new java.awt.Color(255, 255, 255));
        txtName.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtName.setPhColor(new java.awt.Color(204, 0, 204));
        txtName.setPlaceholder("Enter Name..");

        rSMaterialButtonRectangle2.setBackground(new java.awt.Color(0, 0, 153));
        rSMaterialButtonRectangle2.setText("ADD");
        rSMaterialButtonRectangle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle2MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle2ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle3.setBackground(new java.awt.Color(102, 0, 51));
        rSMaterialButtonRectangle3.setText("UPDATE");
        rSMaterialButtonRectangle3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle3MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle3ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle4.setBackground(new java.awt.Color(102, 0, 0));
        rSMaterialButtonRectangle4.setText("DELETE");
        rSMaterialButtonRectangle4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonRectangle4MouseClicked(evt);
            }
        });
        rSMaterialButtonRectangle4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle4ActionPerformed(evt);
            }
        });

        tblCustomer.setBackground(new java.awt.Color(51, 51, 51));
        tblCustomer.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(153, 0, 153)));
        tblCustomer.setForeground(new java.awt.Color(255, 255, 255));
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Age", "ID type", "ID no", "Contact", "Adress"
            }
        ));
        tblCustomer.setColorBackgoundHead(new java.awt.Color(102, 0, 102));
        tblCustomer.setColorFilasForeground1(new java.awt.Color(102, 0, 102));
        tblCustomer.setColorFilasForeground2(new java.awt.Color(102, 0, 102));
        tblCustomer.setColorSelBackgound(new java.awt.Color(102, 0, 102));
        tblCustomer.setFuenteFilas(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tblCustomer.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tblCustomer.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomer);

        jLabel45.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel45.setText("Contact    :");

        jLabel46.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel46.setText("Address   :");

        jLabel47.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pencil (1).png"))); // NOI18N
        jLabel47.setText("Age          :");

        txtAge.setForeground(new java.awt.Color(153, 0, 153));
        txtAge.setBorderColor(new java.awt.Color(153, 0, 153));
        txtAge.setCaretColor(new java.awt.Color(255, 255, 255));
        txtAge.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtAge.setPhColor(new java.awt.Color(204, 0, 204));
        txtAge.setPlaceholder("Enter Age..");

        txtCustomeridNo.setForeground(new java.awt.Color(153, 0, 153));
        txtCustomeridNo.setBorderColor(new java.awt.Color(153, 0, 153));
        txtCustomeridNo.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCustomeridNo.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtCustomeridNo.setPhColor(new java.awt.Color(204, 0, 204));
        txtCustomeridNo.setPlaceholder("Enter ID No..");

        txtContact.setForeground(new java.awt.Color(153, 0, 153));
        txtContact.setBorderColor(new java.awt.Color(153, 0, 153));
        txtContact.setCaretColor(new java.awt.Color(255, 255, 255));
        txtContact.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtContact.setPhColor(new java.awt.Color(204, 0, 204));
        txtContact.setPlaceholder("Enter Contact No..");

        txtAddress.setForeground(new java.awt.Color(153, 0, 153));
        txtAddress.setBorderColor(new java.awt.Color(153, 0, 153));
        txtAddress.setCaretColor(new java.awt.Color(255, 255, 255));
        txtAddress.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        txtAddress.setPhColor(new java.awt.Color(204, 0, 204));
        txtAddress.setPlaceholder("Enter Address..");

        cmbIDType.setBackground(new java.awt.Color(51, 51, 51));
        cmbIDType.setEditable(true);
        cmbIDType.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        cmbIDType.setForeground(new java.awt.Color(51, 0, 51));
        cmbIDType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "National ID", "Driving Liscen", " " }));
        cmbIDType.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 0, 153)));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomeridNo, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbIDType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbIDType, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCustomeridNo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMaterialButtonRectangle2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSMaterialButtonRectangle4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel3.add(jPanel16);
        jPanel16.setBounds(10, 10, 1000, 490);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallpaperflare.com_wallpaper (5).jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 1061, 510);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(250, 50, 1020, 510);

        setSize(new java.awt.Dimension(1268, 558));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSMaterialButtonRectangle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle2MouseClicked

    private void rSMaterialButtonRectangle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle2ActionPerformed
        if(addCustomer()== true){
            JOptionPane.showMessageDialog(this, "Data inserted Successfully");
            clearTable();
            setCustomerDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data insert fail");
        }
        
      
    }//GEN-LAST:event_rSMaterialButtonRectangle2ActionPerformed

    private void rSMaterialButtonRectangle3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle3MouseClicked

    private void rSMaterialButtonRectangle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle3ActionPerformed
         if(updateCustomer()== true){
            JOptionPane.showMessageDialog(this, "Data updated Successfully");
            clearTable();
            setCustomerDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data update fail");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle3ActionPerformed

    private void rSMaterialButtonRectangle4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_rSMaterialButtonRectangle4MouseClicked

    private void rSMaterialButtonRectangle4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle4ActionPerformed
         if(deleteCustomer()== true){
            JOptionPane.showMessageDialog(this, "Data deleted Successfully");
            clearTable();
            setCustomerDetailsIntoTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Data delete fail");
        }
    }//GEN-LAST:event_rSMaterialButtonRectangle4ActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
       int rowNo = tblCustomer.getSelectedRow();
        TableModel model = tblCustomer.getModel();
        
        txtCustomerID.setText(model.getValueAt(rowNo,0).toString());
        txtName.setText(model.getValueAt(rowNo,1).toString());
        txtAge.setText(model.getValueAt(rowNo,2).toString());
        cmbIDType.setSelectedItem(model.getValueAt(rowNo,3).toString());
        txtCustomeridNo.setText(model.getValueAt(rowNo,4).toString());
        txtContact.setText(model.getValueAt(rowNo,5).toString());
        txtAddress.setText(model.getValueAt(rowNo,6).toString());
    }//GEN-LAST:event_tblCustomerMouseClicked

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
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbIDType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
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
    private rojeru_san.complementos.RSButtonHover rSButtonHover1;
    private rojeru_san.complementos.RSButtonHover rSButtonHover2;
    private rojeru_san.complementos.RSButtonHover rSButtonHover3;
    private rojeru_san.complementos.RSButtonHover rSButtonHover4;
    private rojeru_san.complementos.RSButtonHover rSButtonHover5;
    private rojeru_san.complementos.RSButtonHover rSButtonHover6;
    private rojeru_san.complementos.RSButtonHover rSButtonHover7;
    private rojeru_san.complementos.RSButtonHover rSButtonHover8;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle2;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle4;
    private rojeru_san.complementos.RSTableMetro tblCustomer;
    private rojerusan.RSMetroTextPlaceHolder txtAddress;
    private rojerusan.RSMetroTextPlaceHolder txtAge;
    private rojerusan.RSMetroTextPlaceHolder txtContact;
    private rojerusan.RSMetroTextPlaceHolder txtCustomerID;
    private rojerusan.RSMetroTextPlaceHolder txtCustomeridNo;
    private rojerusan.RSMetroTextPlaceHolder txtName;
    // End of variables declaration//GEN-END:variables
}

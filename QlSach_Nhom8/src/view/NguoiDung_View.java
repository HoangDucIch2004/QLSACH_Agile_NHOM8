package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.HoaDonChiTiet_Model;
import model.NguoiDung_model;
import model.Sach_Model;
import service.NguoiDung_Service;
import service.Sach_Service;

/**
 *
 * @author TIEN DUY
 */
public class NguoiDung_View extends javax.swing.JFrame {

    /**
     * Creates new form NguoiDung_View
     */
    private Sach_Service ss = new Sach_Service();
    private NguoiDung_Service nds = new NguoiDung_Service();
    private DefaultTableModel model1 = new DefaultTableModel();
    private DefaultTableModel model2 = new DefaultTableModel();
    private int index = -1;

    public NguoiDung_View() {
        initComponents();
        setLocationRelativeTo(null);
        model1 = (DefaultTableModel) tblSachCuaShop.getModel();
        fillTable1();

        model2 = (DefaultTableModel) tblHoaDon.getModel();
        fillTable2();

    }

    public void fillTable1() {

        model1.setRowCount(0);// xóa sạch bảng
        List<Sach_Model> list = ss.getAllbenHoaDon();
        for (Sach_Model sv : list) {
            model1.addRow(sv.toDataRowbenHoaDon());
        }

    }

    public void fillTable2() {
        model2.setRowCount(0); // Xóa sạch bảng
        List<NguoiDung_model> list = nds.getAll();
        for (NguoiDung_model nd : list) {
            model2.addRow(nd.todataRow()); // Thêm hàng vào bảng
        }
        double tongTien = tinhTongTien(tblHoaDon);  // Truyền vào tblHoaDon là tên biến của JTable bạn đang sử dụng
        lblTongTien.setText(String.valueOf(tongTien));
    }

    public NguoiDung_model save() {
        NguoiDung_model nd = new NguoiDung_model();

        Sach_Model s = new Sach_Model(txtMa.getText(), txtTen.getText());
        nd.setS(s);
        nd.setSoluongmua(Integer.valueOf(txtSoLuong.getText()));
        nd.setDiachi(txtDiaChi.getText());
        nd.setSdt(txtsdt.getText());
        nd.setThanhtien(Double.valueOf(lblGia.getText()));
        return nd;
    }

    public HoaDonChiTiet_Model save1() {
        HoaDonChiTiet_Model nd = new HoaDonChiTiet_Model();

        Sach_Model s = new Sach_Model(txtMa.getText(), txtTen.getText());
        nd.setS(s);
        NguoiDung_model m = new NguoiDung_model(new Sach_Model(txtMa.getText(), txtTen.getText()),
                Integer.valueOf(txtSoLuong.getText()),
                txtDiaChi.getText(),
                txtsdt.getText(),
                Double.parseDouble(lblGia.getText()));
        nd.setNd(m);
        if (rdThanhToanOff.isSelected()) {
            nd.setHinhthucThanhToan("Tiền mặt");
        }
        if (rdThanhToanOnl.isSelected()) {
            nd.setHinhthucThanhToan("Chuyển khoản");
        }
        return nd;
    }

    public void clearForm() {
        txtMa.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtSoLuong.setText("");
        txtsdt.setText("");
        lblGia.setText("0.0");
        index = -1;
    }

    public boolean check() {
        if (txtMa.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sách không được để trống!", "Báo lỗi", 0);
            return false;
        }
        if (txtTen.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Tên sách không được để trống!", "Báo lỗi", 0);
            return false;
        }
        if (txtDiaChi.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!", "Báo lỗi", 0);
            return false;
        }
        if (txtsdt.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "SĐT không được để trống!", "Báo lỗi", 0);
            return false;
        }
        if (txtSoLuong.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Số lượng không được để trống!", "Báo lỗi", 0);
            return false;
        }
        try {
            int soluong = Integer.parseInt(txtSoLuong.getText());
            if (soluong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải > 0!", "Báo lỗi", 0);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số!", "Báo lỗi", 3);
            return false;
        }

        return true;
    }

    public boolean Check2() {
        if (!rdThanhToanOff.isSelected() && !rdThanhToanOnl.isSelected()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hình thức thanh toán!", "Báo lỗi", 0);
            return false;
        }
        return true;
    }

    public double tinhTongTien(JTable tblHoaDon) {
        double tongTien = 0.0;
        int rowCount = tblHoaDon.getRowCount();
        int thanhTienColumnIndex = 6;  // Chỉ số cột "Thành tiền" (số 6)

        for (int i = 0; i < rowCount; i++) {
            Object thanhTienObj = tblHoaDon.getValueAt(i, thanhTienColumnIndex);
            if (thanhTienObj instanceof Double) {
                double thanhTien = (Double) thanhTienObj;
                tongTien += thanhTien;
            }
        }

        return tongTien;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSachCuaShop = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        themvaoGioHang = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lblGia = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        DatHang = new javax.swing.JButton();
        xoaKhoiGioHang = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        rdThanhToanOff = new javax.swing.JRadioButton();
        rdThanhToanOnl = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 204));
        jLabel1.setText("Người dùng");

        tblSachCuaShop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sách", "Tên sách", "Số lượng trong kho", "Giá"
            }
        ));
        tblSachCuaShop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachCuaShopMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSachCuaShop);

        jLabel2.setText("Mã sách");

        jLabel3.setText("Tên sách");

        jLabel4.setText("Số Lượng mua");

        themvaoGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Add to basket.png"))); // NOI18N
        themvaoGioHang.setText("Thêm vào giỏ hàng");
        themvaoGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themvaoGioHangActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Mã sách", "Tên sách", "Số Lượng mua", "Địa chỉ", "Số điện thoại", "Thành tiền"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        jLabel5.setText("Địa chỉ");

        jLabel6.setText("Số Điện thoại");

        jLabel7.setText("Thành tiền:");

        lblGia.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblGia.setForeground(new java.awt.Color(255, 0, 0));
        lblGia.setText("0");

        jLabel9.setForeground(new java.awt.Color(255, 51, 51));
        jLabel9.setText("VNĐ");

        DatHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Accept.png"))); // NOI18N
        DatHang.setText("Đặt hàng");
        DatHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatHangActionPerformed(evt);
            }
        });

        xoaKhoiGioHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete.png"))); // NOI18N
        xoaKhoiGioHang.setText("Xóa khỏi giỏ hàng");
        xoaKhoiGioHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaKhoiGioHangActionPerformed(evt);
            }
        });

        jLabel10.setText("Hình thức thanh toán");

        buttonGroup1.add(rdThanhToanOff);
        rdThanhToanOff.setText("Thanh toán khi nhận hàng");

        buttonGroup1.add(rdThanhToanOnl);
        rdThanhToanOnl.setText("Thanh toán online");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setText("Tổng tiền:");

        lblTongTien.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 0, 0));
        lblTongTien.setText("0");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("VNĐ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Calendar.png"))); // NOI18N
        jButton1.setText("Lịch sử mua hàng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Search.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(DatHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(xoaKhoiGioHang, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(60, 60, 60)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(65, 65, 65)
                                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(67, 67, 67)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addComponent(themvaoGioHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtsdt, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(txtDiaChi)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGia, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(34, 34, 34)
                        .addComponent(rdThanhToanOff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdThanhToanOnl))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(lblTongTien)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(lblGia)
                    .addComponent(jLabel9))
                .addGap(12, 12, 12)
                .addComponent(themvaoGioHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTongTien)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(rdThanhToanOff)
                    .addComponent(rdThanhToanOnl))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DatHang)
                    .addComponent(xoaKhoiGioHang)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSachCuaShopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachCuaShopMouseClicked
        // TODO add your handling code here:
        index = tblSachCuaShop.getSelectedRow();
        if (index > -1) {
            txtMa.setText(tblSachCuaShop.getValueAt(index, 0).toString());
            txtTen.setText(tblSachCuaShop.getValueAt(index, 1).toString());
        }
    }//GEN-LAST:event_tblSachCuaShopMouseClicked

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        index = tblHoaDon.getSelectedRow();
        if (index > -1) {
            txtMa.setText(tblHoaDon.getValueAt(index, 1).toString());
            txtTen.setText(tblHoaDon.getValueAt(index, 2).toString());
            txtSoLuong.setText(tblHoaDon.getValueAt(index, 3).toString());
            txtDiaChi.setText(tblHoaDon.getValueAt(index, 4).toString());
            txtsdt.setText(tblHoaDon.getValueAt(index, 5).toString());
            lblGia.setText(tblHoaDon.getValueAt(index, 6).toString());
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void themvaoGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themvaoGioHangActionPerformed
        // TODO add your handling code here:
        if (check()) {
            try {

                int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn thêm sp: " + txtMa.getText() + " này vào giỏ hàng không ?");
                if (hoi != JOptionPane.YES_OPTION) {
                    return;
                }
                NguoiDung_model nd = save();
                if (nds.insertHoaDon(nd) != null) {
                    fillTable2();
                    JOptionPane.showMessageDialog(this, "Thêm thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi nút thêm");
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_themvaoGioHangActionPerformed

    private void xoaKhoiGioHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaKhoiGioHangActionPerformed
        // TODO add your handling code here:
        index = tblHoaDon.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn dòng nào cả!");
        }
        if (index > -1) {
            try {
                int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sp: " + txtMa.getText() + " này khỏi giỏ hàng không ?");
                if (hoi != JOptionPane.YES_OPTION) {
                    return;
                }
                String ma = tblHoaDon.getValueAt(index, 0).toString();
                if (nds.deleteHoaDon(ma) != null) {
                    fillTable2();
                    clearForm();
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại!");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Lỗi nút Xóa!");
            }
        }
    }//GEN-LAST:event_xoaKhoiGioHangActionPerformed

    private void DatHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatHangActionPerformed
        // TODO add your handling code here:
        index = tblHoaDon.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm muốn đặt hàng!");
            return;
        } else {
            if (Check2()) {

                try {

                    int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn đặt hàng sp: " + txtMa.getText() + " này không ?");
                    if (hoi != JOptionPane.YES_OPTION) {
                        return;
                    }
                    String ma = tblHoaDon.getValueAt(index, 0).toString();
                    HoaDonChiTiet_Model nd = save1();
                    if (nds.insertHoaDonChiTiet(nd) != null) {

                        if (nds.deleteHoaDon(ma) != null) {
                            fillTable2();
                            clearForm();
                            JOptionPane.showMessageDialog(this, "Đặt hàng thành công!");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Đặt hàng thất bại!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi nút Đặt hàng");
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_DatHangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        NguoiDung_HoaDonChiTiet vhd = new NguoiDung_HoaDonChiTiet();
        vhd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        List<Sach_Model> list = new ArrayList<>();
        String ten = txtTim.getText();

        if (ten.isEmpty()) {
            model1.setRowCount(0);
            list = ss.getAllbenHoaDon();
        } else {
            model1.setRowCount(0);
            list = ss.timkiemtheoTen(ten);
        }

        for (Sach_Model sv : list) {
            model1.addRow(sv.toDataRowbenHoaDon());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(NguoiDung_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NguoiDung_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NguoiDung_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NguoiDung_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NguoiDung_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DatHang;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblGia;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JRadioButton rdThanhToanOff;
    private javax.swing.JRadioButton rdThanhToanOnl;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSachCuaShop;
    private javax.swing.JButton themvaoGioHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JButton xoaKhoiGioHang;
    // End of variables declaration//GEN-END:variables
}

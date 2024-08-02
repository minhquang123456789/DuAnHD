package pro1041.com.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pro1041.com.entity.KhachHang;
import pro1041.com.service.KhachHangService;

public class formThemKH extends javax.swing.JDialog {

    List<KhachHang> listKhachHang = new ArrayList<>();
    private final KhachHangService khachHangService = new KhachHangService();
    DefaultTableModel model = new DefaultTableModel();
    public static String maKH;

    public formThemKH(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        fillToTable();
        taoMa();
        txtMaKH.setText(maKH);
    }

    public void fillToTable() {
        listKhachHang = khachHangService.getAll();
        model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        for (KhachHang s : listKhachHang) {
            model.addRow(new Object[]{
                s.getMaKh(), s.getHoTenKh(), s.getGioiTinh(), s.getSdt(), s.getSdt(), s.getEmail(), s.getDiaChi()});
        }
    }

    public void click() {
        int row = tblKhachHang.getSelectedRow();
        maKH = tblKhachHang.getValueAt(row, 0).toString();
    }

    void dong() {
        click();
        this.dispose();
    }

    public boolean isValidPhoneNumber(String sdt) {
        String regex = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sdt);
        return matcher.matches();
    }

    private void taoMa() {
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            int x = random.nextInt() + 10;
            if (x < 0) {
                x = x * -1;
            }
            maKH = "KH" + x;
        }
    }

    void clearForm() {
        txtDiaChi.setText("");
        
        txtSDT.setText("");
        txtHoTen.setText("");
        buttonGroup1.clearSelection();
        Date now = new Date();
        jNgayTao.setDate(now);
    }

    public void showDetail(int index) {
        KhachHang kh = listKhachHang.get(index);
        txtMaKH.setText(kh.getMaKh());
        txtHoTen.setText(kh.getHoTenKh());
        txtDiaChi.setText(kh.getDiaChi());
        txtSDT.setText(kh.getSdt());

        jNgayTao.setDate(kh.getNgayTao());
        String gioiTinh = kh.getGioiTinh();
        if (gioiTinh != null) {
            if (gioiTinh.equalsIgnoreCase("Nam")) {
                rdoNam.setSelected(true);
            } else if (gioiTinh.equalsIgnoreCase("Nữ")) {
                rdoNu.setSelected(true);
            } else {
                rdoNam.setSelected(false);
                rdoNu.setSelected(false);
            }
        } else {
            rdoNam.setSelected(false);
            rdoNu.setSelected(false);
        }
    }

    public KhachHang getForm() {
        KhachHang kh = new KhachHang();
        String ma = txtMaKH.getText().trim();
        String ten = txtHoTen.getText().trim();
        String sdt = txtSDT.getText().trim();
        String diaChi = txtDiaChi.getText().trim();
        Date ngayTao = jNgayTao.getDate();
        String gioiTinh = "";
        if (rdoNam.isSelected()) {
            gioiTinh = "Nam";
        } else if (rdoNu.isSelected()) {
            gioiTinh = "Nữ";
        }
        kh.setHoTenKh(ten);
        kh.setDiaChi(diaChi);
        kh.setMaKh(ma);
        kh.setSdt(sdt);
        kh.setNgayTao(ngayTao);
        kh.setGioiTinh(gioiTinh);
        return kh;
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
        scrollPane1 = new java.awt.ScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtPanel = new javax.swing.JTabbedPane();
        jDanhSach = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        spKH = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jADDKH = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jNgayTao = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jDanhSach.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("DANH SÁCH KHÁCH HÀNG");

        spKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spKHMouseClicked(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MÃ KHÁCH HÀNG", "TÊN KHÁCH HÀNG", "GIỚI TÍNH", "NGÀY TẠO ", "SỐ ĐIỆN THOẠI", "ĐỊA CHỈ"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        spKH.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jDanhSachLayout = new javax.swing.GroupLayout(jDanhSach);
        jDanhSach.setLayout(jDanhSachLayout);
        jDanhSachLayout.setHorizontalGroup(
            jDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDanhSachLayout.createSequentialGroup()
                        .addComponent(spKH)
                        .addContainerGap())
                    .addGroup(jDanhSachLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 415, Short.MAX_VALUE))))
        );
        jDanhSachLayout.setVerticalGroup(
            jDanhSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDanhSachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addComponent(spKH, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        txtPanel.addTab("CHỌN KHÁCH HÀNG", jDanhSach);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jADDKH.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("THÊM THÔNG TIN KHÁCH HÀNG");

        jLabel3.setText("TÊN KHÁCH HÀNG");

        jLabel4.setText("GIỚI TÍNH");

        jLabel7.setText("SỐ ĐIỆN THOẠI");

        jLabel8.setText("ĐỊA CHỈ");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pro1041/com/icon/icons8-add-16.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNam);
        rdoNam.setText("NAM");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("NỮ");

        jLabel9.setText("MÃ KHÁCH HÀNG");

        txtMaKH.setEnabled(false);
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        jLabel10.setText("NGÀY TẠO");

        javax.swing.GroupLayout jADDKHLayout = new javax.swing.GroupLayout(jADDKH);
        jADDKH.setLayout(jADDKHLayout);
        jADDKHLayout.setHorizontalGroup(
            jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jADDKHLayout.createSequentialGroup()
                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jADDKHLayout.createSequentialGroup()
                        .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jADDKHLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jADDKHLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)))
                        .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jADDKHLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                        .addComponent(txtSDT)
                                        .addComponent(txtDiaChi)
                                        .addComponent(jNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jADDKHLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jADDKHLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addComponent(btnThem))
                    .addGroup(jADDKHLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jADDKHLayout.setVerticalGroup(
            jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jADDKHLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(jLabel9)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(10, 10, 10)
                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jADDKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jADDKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jADDKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtPanel.addTab("THÊM KHÁCH HÀNG", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPanel)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        String ma = txtMaKH.getText().trim();
        String ten = txtHoTen.getText().trim();
        String sdt = txtSDT.getText().trim();
        if (ma.isEmpty() && ten.isEmpty() && ma.isBlank() && ten.isBlank()) {
            JOptionPane.showMessageDialog(this, "Tên và mã khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (ma.isBlank() || ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (ten.isBlank() || ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        } else if (!isValidPhoneNumber(sdt) || sdt.isBlank() || sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (khachHangService.add(getForm()) != 0) {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            clearForm();
            listKhachHang = khachHangService.getAll();
            fillToTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thêm không thành công");
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTenThuocTinh8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenThuocTinh8KeyReleased

    }//GEN-LAST:event_txtTenThuocTinh8KeyReleased

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        click();
        dong();
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void spKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_spKHMouseClicked

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                formThemKH dialog = new formThemKH(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jADDKH;
    private javax.swing.JPanel jDanhSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JDateChooser jNgayTao;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JScrollPane spKH;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTabbedPane txtPanel;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables

}

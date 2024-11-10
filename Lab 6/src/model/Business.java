/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Varnika Mujumdar
 */
public class Business {
    
    MasterOrderList masterOrderList;
    SupplierDirectory supplierDirectory;
    Order currentOrder;

    public Business() {
        
        masterOrderList = new MasterOrderList();
        supplierDirectory = new SupplierDirectory();
        currentOrder = new Order();
    }

    public MasterOrderList getMasterOrderList() {
        return masterOrderList;
    }

    public void setMasterOrderList(MasterOrderList masterOrderList) {
        this.masterOrderList = masterOrderList;
    }

    public SupplierDirectory getSupplierDirectory() {
        return supplierDirectory;
    }

    public void setSupplierDirectory(SupplierDirectory supplierDirectory) {
        this.supplierDirectory = supplierDirectory;
    }

    public Order getOrder() {
        return currentOrder;
    }

    public void setOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
    
    
    
}

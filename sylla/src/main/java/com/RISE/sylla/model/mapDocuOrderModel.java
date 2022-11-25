package com.RISE.sylla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="map_docu_order")
public class mapDocuOrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmapdocuorder")
    private int idMapDocuOrder;

    @Column(name="fkdocument_Docorder")
    private int fkDocument_DocOrder;

    @Column(name="fkorder_Docorder")
    private int fkOrder_DocOrder;

    public int getIdMapDocuOrder() {
        return idMapDocuOrder;
    }

    public void setIdMapDocuOrder(int idMapDocuOrder) {
        this.idMapDocuOrder = idMapDocuOrder;
    }

    public int getFkDocument_DocOrder() {
        return fkDocument_DocOrder;
    }

    public void setFkDocument_DocOrder(int fkDocument_DocOrder) {
        this.fkDocument_DocOrder = fkDocument_DocOrder;
    }

    public int getFkOrder_DocOrder() {
        return fkOrder_DocOrder;
    }

    public void setFkOrder_DocOrder(int fkOrder_DocOrder) {
        this.fkOrder_DocOrder = fkOrder_DocOrder;
    }
}

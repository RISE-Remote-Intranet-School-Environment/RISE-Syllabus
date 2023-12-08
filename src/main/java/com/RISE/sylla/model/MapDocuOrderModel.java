package com.RISE.sylla.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="map_docu_order")
public class MapDocuOrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmapdocuorder")
    private Long idMapDocuOrder;

    @Column(name="fkdocument")
    private Long fkdocument;

    @Column(name="fkorder")
    private Long fkorder;

    public Long getIdMapDocuOrder() {
        return idMapDocuOrder;
    }

    public void setIdMapDocuOrder(Long idMapDocuOrder) {
        this.idMapDocuOrder = idMapDocuOrder;
    }

    public Long getFkdocument() {
        return fkdocument;
    }

    public void setFkdocument(Long fkDocument_DocOrder) {
        this.fkdocument = fkDocument_DocOrder;
    }

    public Long getFkorder() {
        return fkorder;
    }

    public void setFkorder(Long fkOrder_DocOrder) {
        this.fkorder = fkOrder_DocOrder;
    }
}

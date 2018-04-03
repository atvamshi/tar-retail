package com.myretail.retail.mvc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Project: myretail-parent
 * Package: com.myretail.retail.mvc
 * <p>
 * User: vthalapu
 * Date: 3/12/18
 * Time: 9:56 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "ItemsPriceDetails")
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PriceDetailsModel implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemPrimaryKey;

    @Column(name = "Item_Id")
    private Integer itemId;

    @Column(name = "Item_Name")
    private String itemName;

    @Column(name = "Item_Price")
    private float itemPrice;

    @Column(name = "Item_Currency_Type")
    private String itemCurrencyType;

}

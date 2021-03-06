package com.zaynukov.dev.obj.dto;

import com.zaynukov.dev.dbmodel.CreatedOrderEntity;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 */
public class OrderDTO {
    private long orderId;
    private String customerName;
    private String customerAddress;
    private String sum;
    private String createdDate;
    private List<ProductItemDTO> productList;

    public OrderDTO() {
    }

    public OrderDTO(long orderId, String customerName, String customerAddress, String sum, String createdDate, List<ProductItemDTO> productList) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.sum = sum;
        this.createdDate = createdDate;
        this.productList = productList;
    }

    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");

    public OrderDTO(CreatedOrderEntity orderEntity) {
        this(
                orderEntity.getId(),
                orderEntity.getCustomerName(),
                orderEntity.getCustomerAddress(),
                String.valueOf(orderEntity.getSum()),
                sdf.format(orderEntity.getCreatedDatetime()),
                orderEntity.getDetails().stream().map(
                        detail -> new ProductItemDTO(detail.getSerialId(), String.valueOf(detail.getCount())))
                        .collect(Collectors.toList())
        );
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public List<ProductItemDTO> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductItemDTO> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return orderId == orderDTO.orderId &&
                Objects.equals(customerName, orderDTO.customerName) &&
                Objects.equals(customerAddress, orderDTO.customerAddress) &&
                Objects.equals(sum, orderDTO.sum) &&
                Objects.equals(createdDate, orderDTO.createdDate) &&
                Objects.equals(productList, orderDTO.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerName, customerAddress, sum, createdDate, productList);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", sum='" + sum + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", productList=" + productList +
                '}';
    }
}

package com.springboot.springbootstudy.data.dto;

public class ProductResponseDto {
    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductResponseDto() { }

    public ProductResponseDto(Long number, String name, int price, int stock) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Long getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    /*
    빌더 패턴을 따르는 메서드.
    데이터 클래스를 사용할 때 생성자로 초기화할 경우 모든 필드에 값을 넣거나 null을 명시적으로 사용해야함.
    이러한 단점을 보완하기 나온 것이 빌더 패턴이며, 필요한 데이터만 설정할 수 있어 유연성을 확보 할 수 있다.
    */
    public ProductResponseDto build() {
        return new ProductResponseDto(number, name, price, stock);
    }

    @Override
    public String toString() {
        return "ProductResponseDto{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

package xj;


import lombok.Getter;

public enum CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");
    @Getter private int key;
    @Getter private String value;

    CountryEnum(int key,String value) {
        this.key = key;
        this.value = value;
    }
    public static CountryEnum getEnum(int index){
        CountryEnum[] arr = CountryEnum.values();
        for (CountryEnum ce:
             arr) {
            if(ce.getKey() == index){
                return ce;
            }
        }
        return null;
    }

}

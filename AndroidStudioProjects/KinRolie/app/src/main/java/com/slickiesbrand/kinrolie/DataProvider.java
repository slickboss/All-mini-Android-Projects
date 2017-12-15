package com.slickiesbrand.kinrolie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SLICKBOSS on 7/21/2016.
 */
public final class DataProvider {

    public static List<Product> productList = new ArrayList<>();
    public static Map<String, Product> productMap= new HashMap<>();


    static {

        addProduct("mat01",
                " Make Delicious Snail ",
                "this is a make delicious snail, Nutricious and snazzy.. You can have a bite by making an order at click On the message icon below",
                0);

        addProduct("mat02",
                "A day Old Chick",
                "Make an order for a day old chick now",
                0);

        addProduct("mat03",
                "Feeding Snails",
                "Order for many...bet you will love it",
                0);

        addProduct("mat04",
                "Feeding Chicks",
                "Chicks feeding in their cage",
                0);

        addProduct("mat05",
                "Freshly packed snail",
                "Packaged Snail, You can order for your, fresh daily packed snail, well cleaned and fresh!",
                0);

        addProduct("mat06",
                "Crates Of Eggs",
                "This medium-weight sweater, made from organic knitted cotton and bamboo, is the perfect solution to a chilly night at the campground or a misty walk on the beach.",
                0);

        addProduct("mat07",
                "Snails",
                " ...",
                0);

        addProduct("mat08",
                "Chicks\n",
                ".",
                0);

        addProduct("mat09",
                "Feeding Snails",
                "",
                0);

        addProduct("mat10",
                "Hot meal",
                "",
                0);

        addProduct("mat11",
                "",
                "Order now",
                0);

        addProduct("mat12",
                "",
                "",
                0);

        addProduct("mat13",
                "Hot",
                "For your hot meal",
                5);

        addProduct("mat14",
                "",
                "",
                0);


        addProduct("mat15",
                "",
                "",
                0);



        addProduct("mat20",
                "",
                "",
                0);





        addProduct("mat17",
                " ",
                "",
                0);




        addProduct("mat18",
                " ",
                " ",
                10);


        addProduct("mat19",
                "",
                " ",
                0);


        addProduct("mat20",
                "",
                " ",
                0);








    }

    private static void addProduct(String itemId, String name,
                                   String description, double price) {
        Product item = new Product(itemId, name, description, price);
        productList.add(item);
        productMap.put(itemId, item);
    }

    public static List<String> getProductNames() {
        List<String> list = new ArrayList<>();
        for (Product product : productList) {
            list.add(product.getName());
        }
        return list;
    }

    public static List<Product> getFilteredList(String searchString) {

        List<Product> filteredList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductId().contains(searchString)) {
                filteredList.add(product);
            }
        }

        return filteredList;

    }

}
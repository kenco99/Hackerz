package yoyo.collacoken.org.test;

    public class MainRv {
        private int id;
        private String title;
        private String price;
        private int image;

        public MainRv(int id, String title, String price, int image) {
            this.id = id;
            this.title = title;
            this.price = price;
            this.image = image;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getPrice() {
            return price;
        }

        public int getImage() {
            return image;
        }
    }




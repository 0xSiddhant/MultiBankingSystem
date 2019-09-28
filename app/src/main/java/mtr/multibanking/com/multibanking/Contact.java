package mtr.multibanking.com.multibanking;

    public class Contact{

        private int id;
        private String name,email,username,password;

        public void setId(int id){
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setName(String name){
            this.name = name;
        }
        public String getName() {
            return name;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public String getEmail() {
            return email;
        }
        public void setUsername(String username) {
            this.username = username;
        }
        public String getUsername() {
            return username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }
    }


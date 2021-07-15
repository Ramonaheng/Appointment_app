package com.example.doctors_appointment_app;

public
class info {

       private String name, surname, email, phone, birthday, city;

        public
        info ( String name, String surname, String email, String phone, String birthday, String city ) {
            this.name     = name;
            this.surname  = surname;
            this.email    = email;
            this.phone    = phone;
            this.birthday = birthday;
            this.city     = city;
        }

        public
        String getName ( ) {
            return name;
        }

        public
        void setName ( String name ) {
            this.name = name;
        }

        public
        String getSurname ( ) {
            return surname;
        }

        public
        void setSurname ( String surname ) {
            this.surname = surname;
        }

        public
        String getEmail ( ) {
            return email;
        }

        public
        void setEmail ( String email ) {
            this.email = email;
        }

        public
        String getPhone ( ) {
            return phone;
        }

        public
        void setPhone ( String phone ) {
            this.phone = phone;
        }

        public
        String getBirthday ( ) {
            return birthday;
        }

        public
        void setBirthday ( String birthday ) {
            this.birthday = birthday;
        }

        public
        String getCity ( ) {
            return city;
        }

        public
        void setCity ( String city ) {
            this.city = city;
        }
    }

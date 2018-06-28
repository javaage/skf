export var activePath : any = {
    code: '',
    name: '',
    company: '',
    address: '',
    password: '',
    phone: '',
    email: '',
    img: '',
    load: function(val){
        this.code = val.code;
        this.name = val.name;
        this.company = val.company;
        this.address = val.address;
        this.password = val.password;
        this.phone = val.phone;
        this.email = val.email;
        this.img = val.img;
    }
};

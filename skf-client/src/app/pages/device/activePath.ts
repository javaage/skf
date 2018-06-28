export var activePath : any = {
    oemCode: '',
    customerCode: '',
    equipmentTypeCode: '',
    equipmentCode: '',
    sensorCode: '',
    componentCode: '',
    gearCode: '',
    bearingCode: '',
    load: function(val){
        this.oemCode = val.oemCode;
        this.customerCode = val.customerCode;
        this.equipmentCode = val.equipmentCode;
        this.equipmentTypeCode = val.equipmentTypeCode;
        this.sensorCode = val.sensorCode;
        this.componentCode = val.componentCode;
        this.gearCode = val.gearCode;
        this.bearingCode = val.bearingCode;
    }
};
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
//import { OEM } from '../model/oem';

@Injectable()
export class DataService  {
  options = { headers: new HttpHeaders({ 'Content-Type': 'application/json' ,'Token':sessionStorage.getItem("token"),'username':sessionStorage.getItem("loginname")}) };
  constructor(private httpClient: HttpClient) { }

  login(username : String,password:String) : Observable<any> {
    let url = environment.baseUrl + `/api/user/login/${username}/${password}/`;
    return this.httpClient.get(url);
  }

  addOEM(oem: any) : Observable<any> {
    let url = environment.baseUrl + '/api/oem';
    return this.httpClient.post(url,oem,this.options);
  }

  listOEM() : Observable<any> {
    let url = environment.baseUrl + '/api/oem/list';
    return this.httpClient.get(url,this.options);
  }

  listOEMWithBLOBs() : Observable<any> {
    let url = environment.baseUrl + '/api/oem/listWithBLOBs';
    return this.httpClient.get(url,this.options);
  }

  getOEMByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/oem/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateOEM(oem: any) : Observable<any> {
    let url = environment.baseUrl + '/api/oem';
    return this.httpClient.put(url,oem,this.options);
  }

  updateOEMWithBLOBs(oem: any) : Observable<any> {
    let url = environment.baseUrl + '/api/oem/blob';
    return this.httpClient.put(url,oem,this.options);
  }

  deleteOEM(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/oem/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  addCustomer(customer: any) : Observable<any> {
    let url = environment.baseUrl + '/api/customer';
    console.log(url);
    console.log(customer);
    console.log(this.options);
    return this.httpClient.post(url,customer,this.options);
  }

  listCustomer() : Observable<any> {
    let url = environment.baseUrl + '/api/customer/list';
    return this.httpClient.get(url,this.options);
  }

  listCustomerByOems(OemCodes) : Observable<any> {
    let url = environment.baseUrl + `/api/customer/listIn/${OemCodes}`;
    return this.httpClient.get(url,this.options);
  }

  listCustomerWithBLOBs() : Observable<any> {
    let url = environment.baseUrl + '/api/customer/listWithBLOBs';
    return this.httpClient.get(url,this.options);
  }

  getCustomerByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/customer/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateCustomer(customer: any) : Observable<any> {
    let url = environment.baseUrl + '/api/customer';
    return this.httpClient.put(url,customer,this.options);
  }

  updateCustomerWithBLOBs(customer: any) : Observable<any> {
    let url = environment.baseUrl + '/api/customer/blob';
    return this.httpClient.put(url,customer,this.options);
  }

  deleteCustomer(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/customer/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  addEquipmentType(equipmentType: any) : Observable<any> {
    let url = environment.baseUrl + '/api/equipmentType';
    console.log(url);
    console.log(equipmentType);
    console.log(this.options);
    return this.httpClient.post(url,equipmentType,this.options);
  }

  listEquipmentType() : Observable<any> {
    let url = environment.baseUrl + '/api/equipmentType/list';
    return this.httpClient.get(url,this.options);
  }

  listEquipmentTypeWithBLOBs() : Observable<any> {
    let url = environment.baseUrl + '/api/equipmentType/list/blob';
    return this.httpClient.get(url,this.options);
  }

  getEquipmentTypeByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/equipmentType/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateEquipmentType(equipmentType: any) : Observable<any> {
    let url = environment.baseUrl + '/api/equipmentType';
    return this.httpClient.put(url,equipmentType,this.options);
  }

  updateEquipmentTypeWithBLOBs(equipmentType: any) : Observable<any> {
    let url = environment.baseUrl + '/api/equipmentType/blob';
    return this.httpClient.put(url,equipmentType,this.options);
  }

  deleteEquipmentType(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/equipmentType/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  addEquipment(equipment: any) : Observable<any> {
    let url = environment.baseUrl + '/api/equipment';
    console.log(url);
    console.log(equipment);
    console.log(this.options);
    return this.httpClient.post(url,equipment,this.options);
  }

  listEquipment() : Observable<any> {
    let url = environment.baseUrl + '/api/equipment/list';
    return this.httpClient.get(url,this.options);
  }

  getEquipmentByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/equipment/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateEquipment(equipment: any) : Observable<any> {
    let url = environment.baseUrl + '/api/equipment';
    return this.httpClient.put(url,equipment,this.options);
  }

  deleteEquipment(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/equipment/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  addSensor(sensor: any) : Observable<any> {
    let url = environment.baseUrl + '/api/sensor';
    console.log(url);
    console.log(sensor);
    console.log(this.options);
    return this.httpClient.post(url,sensor,this.options);
  }

  listSensor() : Observable<any> {
    let url = environment.baseUrl + '/api/sensor/list';
    return this.httpClient.get(url,this.options);
  }

  getSensorByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/sensor/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateSensor(sensor: any) : Observable<any> {
    let url = environment.baseUrl + '/api/sensor';
    return this.httpClient.put(url,sensor,this.options);
  }

  deleteSensor(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/sensor/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  addComponent(component: any) : Observable<any> {
    let url = environment.baseUrl + '/api/component';
    console.log(url);
    console.log(component);
    console.log(this.options);
    return this.httpClient.post(url,component,this.options);
  }

  listComponent() : Observable<any> {
    let url = environment.baseUrl + '/api/component/list';
    return this.httpClient.get(url,this.options);
  }

  getComponentByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/component/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateComponent(component: any) : Observable<any> {
    let url = environment.baseUrl + '/api/component';
    return this.httpClient.put(url,component,this.options);
  }

  deleteComponent(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/component/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  addGear(gear: any) : Observable<any> {
    let url = environment.baseUrl + '/api/gear';
    console.log(url);
    console.log(gear);
    console.log(this.options);
    return this.httpClient.post(url,gear,this.options);
  }

  listGear() : Observable<any> {
    let url = environment.baseUrl + '/api/gear/list';
    return this.httpClient.get(url,this.options);
  }

  getGearByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/gear/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateGear(gear: any) : Observable<any> {
    let url = environment.baseUrl + '/api/gear';
    return this.httpClient.put(url,gear,this.options);
  }

  deleteGear(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/gear/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  addBearing(bearing: any) : Observable<any> {
    let url = environment.baseUrl + '/api/bearing';
    console.log(url);
    console.log(bearing);
    console.log(this.options);
    return this.httpClient.post(url,bearing,this.options);
  }

  listBearing() : Observable<any> {
    let url = environment.baseUrl + '/api/bearing/list';
    return this.httpClient.get(url,this.options);
  }

  getBearingByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateBearing(bearing: any) : Observable<any> {
    let url = environment.baseUrl + '/api/bearing';
    return this.httpClient.put(url,bearing,this.options);
  }

  deleteBearing(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  addUser(user: any) : Observable<any> {
    let url = environment.baseUrl + '/api/user';
    console.log(url);
    console.log(user);
    console.log(this.options);
    return this.httpClient.post(url,user,this.options);
  }

  listUser() : Observable<any> {
    let url = environment.baseUrl + '/api/user/list';
    return this.httpClient.get(url,this.options);
  }

  getUserByCode(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/user/${code}`;
    return this.httpClient.get(url,this.options);
  }

  updateUser(user: any) : Observable<any> {
    let url = environment.baseUrl + '/api/user';
    return this.httpClient.put(url,user,this.options);
  }

  deleteUser(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/user/${code}`;
    return this.httpClient.delete(url,this.options);
  }

  listBearingByOwner(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/list/${code}`;
    return this.httpClient.get(url,this.options);
  }

  listComponentByOwner(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/component/list/${code}`;
    return this.httpClient.get(url,this.options);
  }

  getComponentScoreByID(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/component/getScore/${code}`;
    return this.httpClient.get(url,this.options);
  }

  getComponentScoreByOwerID(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/component/listScore/${code}`;
    return this.httpClient.get(url,this.options);
  }

  listCustomerByOwner(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/customer/list/${code}`;
    return this.httpClient.get(url,this.options);
  }

  listEquipmentByOwner(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/equipment/list/${code}`;
    return this.httpClient.get(url,this.options);
  }

  searchEquipment(search): Observable<any> {
    let url = environment.baseUrl + `/api/equipment/search`;
    return this.httpClient.post(url,search,this.options);
  }

  listEquipmentTypeByOwner(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/equipmentType/list/${code}`;
    return this.httpClient.get(url,this.options);
  }

  listEquipmentTypeByList(listType : String[]) : Observable<any> {
    let url = environment.baseUrl + `/api/equipmentType/listImg`;
    return this.httpClient.post(url,listType,this.options);
  }

  listSensorByOwner(code : String) : Observable<any> {
    let url = environment.baseUrl + `/api/sensor/list/${code}`;
    return this.httpClient.get(url,this.options);
  }

  listOEMTree() : Observable<any> {
    let url = environment.baseUrl + '/api/oem/listTree';
    return this.httpClient.get(url,this.options);
  }

  leaflist(schema : String) : Observable<any> {
    let url = environment.baseUrl + `/api/node/leaflist/${schema}`;
    return this.httpClient.get(url,this.options);
  }

  getNodeValue(schema : String, nodeID : Number) : Observable<any> {
    let url = environment.baseUrl + `/api/node/value/${schema}/${nodeID}`;
    return this.httpClient.get(url,this.options);
  }

  leafpath(schema : String) : Observable<any> {
    let url = environment.baseUrl + `/api/node/leafpath/${schema}`;
    return this.httpClient.get(url,this.options);
  }

  getNodeDatabase() : Observable<any> {
    let url = environment.baseUrl + '/api/node/getNodeDatabase';
    return this.httpClient.get(url,this.options);
  }

  listBearingByModel(modelNumber) : Observable<any> {
    let url = environment.baseUrl + `/api/bearing/listModel/${modelNumber}`;
    return this.httpClient.get(url,this.options);
  }

  listGearByModel(modelNumber) : Observable<any> {
    let url = environment.baseUrl + `/api/gear/listModel/${modelNumber}`;
    return this.httpClient.get(url,this.options);
  }

  getImageByCode(code) : Observable<any> {
    let url = environment.baseUrl + `/api/image/${code}`;
    return this.httpClient.get(url,this.options);
  }
}

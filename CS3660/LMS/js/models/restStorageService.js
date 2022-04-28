/* RestStorageService Class*/

import StorageService from "../models/storageService.js";

export default class RestStorageService extends StorageService {
  constructor(entity, entitySingle, options = {}, host) {
    super(null, null, entity, entitySingle, options);
    this.host = host;    //localhost:8080, from 'endPoint' in appViewModel
  }
  get apiName(){return this.entity;}
  get hostPrefix(){
    return `http://${this.host}`
  }
  get apiUrl(){
    return `${this.hostPrefix}/${this.apiName}`;
  }
  
  async list(options = this.model.options) {
    let url = `${this.apiUrl}/${this.utils.getQueryString(options)}`;
    try {
      const response = await fetch(url)
      this.model.data = await response.json()
      return this.model.data
    }
    catch (msg) {
      console.log(msg)
      throw (msg)
    }
  }
  async read(id) {
    let url = `${this.apiUrl}/${id}`
    try{
      const response = await fetch(url)
      return await response.json()
    }
    catch(err){
      console.log(err)
      throw(err)
    }
      
  }
  async update(id, postData) {
    //Remember for update, you need to set the method to 'PUT' and headers to include
    //'Content-Type': 'application/json'
    //also remember to use JSON.stringify on the postData object before assigning to 'body'
    let sendBody = JSON.stringify(postData)
    let url = `${this.apiUrl}/${id}`
    try {
      const response = await fetch(url, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: sendBody
      })
    }
    catch(msg) {
      console.log(msg)
      throw (msg)
    }
  }
  async create(postData) {
    //Remember for create, you need to set the method to 'POST' and headers to include
    //'Content-Type': 'application/json'
    //also remember to use JSON.stringify on the postData object before assigning to 'body'
    let sendBody = JSON.stringify(postData)
    let url = `${this.apiUrl}/`
    try {
      const response = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: sendBody
      })
    }
    catch(msg) {
      console.log(msg)
      throw (msg)
    }
  }
  async delete(id) {
    let url = `${this.apiUrl}/${id}`
    try{
      const response = await fetch(url, {
        method: 'DELETE'
      })
      this.model.data = await response.json()

    }
    catch(msg) {
      console.log(msg)
      throw (msg)
    }
  }
  
  async getLookup(lookupName){
    let url = `${this.hostPrefix}/lookups/${lookupName}`
    try {
      const response = await fetch(url)
      this.model.lookups = await response.json()
    }
    catch (msg) {
      console.log(msg)
      throw (msg)
    }
      
  }
}
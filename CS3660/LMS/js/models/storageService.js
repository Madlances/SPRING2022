import Utils from '../utils/utilities.js'
export default class StorageService {
  "use strict"
  constructor(data, lookups, entity, entitySingle, options={}) {
    this._entity = entity;
    this._entitySingle = entitySingle;
    this.utils = new Utils();
    this.model ={};
    this.options = options;
    this.model.data=data || [];
    this.model.lookups=lookups || {};
    this.origModel = this.utils.cloneObject(this.model);
  }
  //Getters and Setters
  get lookups(){
    return this.model.lookups;
  }
  get data() {
    return this.model.data;
  }
  get entitySingle() {return this._entitySingle;}
  get entity() {return this._entity;}
  get sortCol() {
    return this.model.options.sortCol;
  }
  set sortCol(col) {
    this.model.options.sortCol = col;
  }
  get sortDir() {
    return this.model.options.sortDir;
  }
  set sortDir(dir) {
    this.model.options.sortDir = dir;
  }
  set filterStr(filterStr) {
    this.model.options.filterStr = filterStr;
  }
  
  get filterStr() {
    return this.model.options.filterStr;
  }
  set filterCol(filterCol) {
    this.model.options.filterCol = filterCol;
  }
  
  get filterCol() {
    return this.model.options.filterCol;
  }
  
  get limit() {
    return this.model.options.limit;
  }
  set limit(limit){
    this.model.options.limit=limit;
  }
  get offset() {
    return this.model.options.offset;
  }
  
  set options(opt){
    this.model.options={
      sortCol: null,
      sortDir: "asc",
      filterCol:"",
      filterStr:"",
      limit: 100,   //we'll set 100 as limit to start
      offset: null
    }
    //merge any passed in options
    this.model.options = Object.assign(this.model.options, opt)
  }
  //API CRUD FUNCTIONS
  async list() {
    throw new Error("must implement list in sub class!")
  }
  async create(obj) {
    throw new Error("must implement create in sub class!")
  }
  async read(getId) {
    throw new Error("must implement read in sub class!")
  }
  async update(id, obj) {
    throw new Error("must implement update in sub class!")
  }
  async delete(removeId) {
    throw new Error("must implement delete in sub class!")
  }
  async reset(){
    throw new Error("must implement delete in sub class!") 
  }
  async getLookup(lookupName){
    //this method retrieves a lookup from either mock data or Rest API and stores in lookups key/val store
    throw new Error("must implement getLookup in sub class!") 
  }
  //Cached Data functions, retrieve from locally cached data.
  getItem(id) {
    return this.model.data.find(element => element.id == id);
  }
  
  lookup(lookupName){
    return this.lookups[lookupName];
  }

  //Utility functions
  getItemIndex(id) {
    return this.model.data.findIndex((element) => element.id == id);
  }
  cloneObject(obj) {
    return JSON.parse(JSON.stringify(obj));
  }
  // create new id for the new team
  newId() {
    const newRandomNumber = () => Math.floor(Math.random() * 10000);
    let newId = newRandomNumber();
    while (this.getItemIndex(newId) !== -1) {
      newId = newRandomNumber();
    }
    return newId;
  }
}
/* Class LocalStorageService- a class for persistant CRUD in LocalStorage
Some tips on order of implementation:
1.  Implement Utility Functions (cloneObject(done), getItemIndex)
2.  Implement 'size' and 'list' getters
3.  Implement localStorage functions 'reset', 'clear', 'store', 'retrieve'
4.  Implement 'read', 'create', 'update', 'delete'
5.  Implement 'sort', 'filter'
*/
class LocalStorageService {
    "use strict";
    constructor(data, key) {
        this.origModel = data;
        this.key = key;

        //if data is NOT in local storage, init and sort using sortCol and sortDir from the model
        if (!this.retrieve()) {
            this.model = this.cloneObject(data); //get copy of data
            this.sort(this.sortCol, this.sortDir, true); //apply default sort
        }
    }
    //Getters
    get sortCol() {
        return this.model.app.sortCol;
    }
    set sortCol(col) {
        this.model.app.sortCol = col;
    }
    get sortDir() {
        return this.model.app.sortDir;
    }
    set sortDir(dir) {
        this.model.app.sortDir = dir;
    }
    get size() {
        //TODO: should return the number of items in model.data
        return this.model.data.length();
    }
    get list() {
        //TODO: return the model.data array
        return this.model.data;
    }

    //CRUD FUNCTIONS
    create(obj) {
        //TODO
        //append new object to data store
        // persist in local storage by calling store()
        this.model.data.push(obj);
        this.store();
    }
    read(getId) {
        //TODO: returns the item in the array with id=getId, null if it is not found
        let index = this.getItemIndex(getId);
        if (index !== -1) {
            return this.model[index];
        } else {
            return null;
        }
    }
    update(obj) {
        //TODO
        //find index of object in array
        //update object with new contents
        // persist in local storage by calling store()
        this.getItemIndex(obj) = obj;
        this.store();
    }

    delete(removeId) {
        //TODO
        //find index of object in array
        //remove object with specified id from model.data (splice?)
        // persist in local storage by calling store()
        let index = this.model.data.findIndex(removeId);
        this.model.data.splice(index, 1);
        this.store();
    }

    //LocalStorage Functions
    reset() {
        //TODO:
        //should clear local storage
        //should restore model from origModel
        //(use utility function 'cloneObject' at bottom of file)
        this.clear();
        this.model = this.cloneObject(this.origModel);
    }
    clear() {
        //TODO: should clear local storage
        localStorage.clear();
    }
    store() {
        //TODO: should store your model in localStorage
        localStorage.setItem(this.key, JSON.stringify(this.model));
    }
    retrieve() {
        //TODO
        //should retrieve your model from localStorage using this.key
        //If data retrieved from LocalStorage, updates this.model
        //hint:  remember to 'parse' the LocalStorage string value back into an object!
        //return true if model retrieved from localStorage, false if key wasn't found in localStorage
        let result = localStorage.getItem(this.key);
        if (result !== null) {
            this.model = JSON.parse(result);
            return true;
        } else {
            return false;
        }
        // return false; //returning false for now
    }

    //Sorting and Filtering Functions
    sort(col, direction, perm = false) {
        //TODO
        //returns a copy of the model.data (util func 'cloneArray'), sorted using the 'col' and 'direction' specifications (see index.html for example)
        // storageSvc.sort('name','asc')
        // if 'perm' param is set to true, you should update the internal model.data
        //with the sorted list, and call 'store' to store in local storage
        //also, store the sort col and direction in the 'app' portion of the model
        let array = this.cloneObject(this.model.data);
        let sortedModel = array.sort((a, b) => (a.col > b.col) ? 1 : -1);

        if (perm === true) {
            this.model.data = sortedModel;
            this.model.data.app.sortCol = col;
            this.model.data.app.sortDir = direction;
            this.store();
        }
        return sortedModel;
        
    }

    filter(filterObj) {
        //returns a copy of the filtered array
        //filterObj contains an object with all the key/value pairs you
        //will filter model.data with.
        //See MDN array 'filter' function documentation
        //Example call: storageSvc.filter({coachLicenseLevel:1,coachLast:"Jenson"});
        let filteredModel = this.model.data.filter(filterObj);
        return filteredModel;
    }

    //Utility functions-IMPLEMENT THESE FIRST
    getItemIndex(id) {
        //TODO
        //return index of team with given id
        //see MDN array 'find' documentation
        //created separate function for this since multiple methods need to get the index of an item
        return this.model.data.findIndex((item) => item.id === id);
    }
    cloneObject(obj) {
        //util function for returning a copy of an object
        return JSON.parse(JSON.stringify(obj)); //giving you this one as of class on Feb 4
    }
}

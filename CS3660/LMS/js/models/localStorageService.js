
/* LocalStorageService*/
/* You will integrate your LocalStorageService from the first assignment, so IMPORTANT you finish Framework1 before 
completing this assignment! */
/* Review this file as I have made several changes. 

1. The 'list' getter function does any sorting or filtering based on the current SortCol, SortDir, and FilterStr 
2. Getters and Setters added for model.options.filterStr
3. Setter for 'options' object added. Default 'options' (sortCol,sortDir) can be passed into constructor-code given
4. SortCol and SortDir getters and setters should use 'this.model.options' instead of 'this.model.app'
5. initModel method added-given*/

class LocalStorageService {
    "use strict"
    constructor(data, key, options={}) {
       
        this.key = key;
       
        this.initModel(data, options);
    }

    //Getters and Setters
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
    get size() {
        return this.model.data.length;
    }
    set options(opt){
        this.model.options={
            sortCol: null,
            sortDir: "asc",
            filterCol:"",
            filterStr:""
        };
        //merge any passed in options
        this.model.options = Object.assign(this.model.options, opt);
    }
    //CRUD FUNCTIONS
     initModel(data, options){
        this.model ={};
        this.model.data=[];
        this.options = options;
        if (data!=null){
            this.model.data=data;
        }
        this.origModel = this.cloneObject(this.model);
       
        this.retrieve();
    }

    async list() {
        this.sort(this.sortCol, this.sortDir, true);
        let filterObj={};
        
        if (this.filterStr){
            filterObj[this.sortCol]=this.filterStr;
            return this.filter(filterObj);
        }
        
        return this.model.data;
    }

     async create(obj) {
        this.model.data.push(obj);
        this.store();
    }
     async read(getId) {
        let data = this.model.data.find(element => element.id == getId);

        if (data === undefined)
            return null;
        else
            return data;
    }
    async update(obj) {
        let index = this.getItemIndex(obj.id);
        if (index != -1) {
            this.model.data[index] = obj;
            this.store();
        }
    }

     async delete(removeId) {
        let index = this.getItemIndex(removeId);
        this.model.data.splice(index, 1)

        this.store();
    }

    //LocalStorage Functions
     async reset() {
        this.model = this.cloneObject(this.origModel);
        this.clear();
    }
     async clear() {
        localStorage.removeItem(this.key);
        localStorage.clear();
    }
     store() {
        localStorage[this.key] = JSON.stringify(this.model);
    }
     retrieve() {
        if (localStorage.getItem(this.key) !== null) {
            this.model = JSON.parse(localStorage[this.key]);
            return true;
        }
        return false;
    }

    //Sorting and Filtering Functions
     sort(col, direction, perm = true) {
        let copy = this.cloneObject(this.model.data);
        let sorted = copy.sort((a, b) => {
            if (a[col] == b[col])
                return 0;
            if (a[col] < b[col]) {
                return direction == "asc" ? -1 : 1;
            }
            if (a[col] > b[col]) {
                return direction == "asc" ? 1 : -1;
            }

        });
        if (perm) {
            this.model.data = sorted;
            this.sortCol = col;
            this.sortDir = direction;

            this.store();
        }
        return sorted;
    }

     filter(filterObj) {
        function filterFunc(team) {
            for (let key in filterObj) {
                if ( !team[key].toLowerCase().includes(filterObj[key].toLowerCase())) {
                    return false;
                }
            }
            return true;
        }
        let result = this.model.data.filter(filterFunc);
        return this.cloneObject(result);
    }

    //Utility functions
    getItemIndex(id) {
        return this.model.data.findIndex(element => element.id == id);

    }
    cloneObject(obj) {
        return JSON.parse(JSON.stringify(obj));
    }

}
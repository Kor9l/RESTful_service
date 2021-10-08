function getIndex(list, id){
   for (var i=0; i<list.length;i++){
       if (list[i].id ===id) {
           return i;
       }
   }
   return -1;
}


var carOfferApi = Vue.resource('/api/carOffer{/id}');

Vue.component('car-view', {
    props: ['caroffer'],
    template:
    '<div>' +
        '<div>Car offer ID: {{caroffer.id}} </div>' +
    '</div>'

})

Vue.component('car-offer-form', {
    props: ['carOffers', 'carOfferAttr'],
    data: function () {
        return {
            brandName: '',
            modelName: '',
            gearBoxType: '',
            fuelType: '',
            cityName: '',
            description: '',
            year: '',
            mileage: '',
            price: '',
            id: ''

        }
    },
    watch: {
        carOfferAttr: function(newVal,oldVal){
            this.brandName = newVal.brandName;
            this.id = newVal.id;
            this.modelName = newVal.modelName;
            this.fuelType = newVal.fuelType;
            this.cityName = newVal.cityName;
            this.description = newVal.description;
            this.year = newVal.year;
            this.mileage= newVal.mileage;
            this.price = newVal.price;
            this.gearBoxType = newVal.gearBoxType;
        }
    },

    template:
        '<div>' +
        '<div><input type="text" v-model="brandName" placeholder ="Enter Brand" /></div>' +
        '<div><input type="text" v-model="modelName" placeholder ="Enter Model" /></div>' +
        '<div><input type="text" v-model="gearBoxType" placeholder ="Enter gear box type" /></div>' +
        '<div><input type="text" v-model="fuelType" placeholder ="Enter fuel type" /></div>' +
        '<div><input type="text" v-model="cityName" placeholder ="Enter your city" /></div>' +
        '<div><input type="text" v-model="description" placeholder ="Write description" /></div>' +
        '<div><input type="text" v-model="year" placeholder ="Enter year" /></div>' +
        '<div><input type="text" v-model="mileage" placeholder ="Enter mileage" /></div>' +
        '<div><input type="text" v-model="price" placeholder ="Enter price" /></div>' +
        '<div><input type="button" value="Save" @click="save" /></div>' +
        '</div>',
    methods: {
        save: function () {
            var carOffer =
                {
                    brandName: this.brandName,
                    modelName: this.modelName,
                    gearBoxType: this.gearBoxType,
                    fuelType: this.fuelType,
                    cityName: this.cityName,
                    description: this.description,
                    year: this.year,
                    mileage: this.mileage,
                    price: this.price,

                };
            if (this.id) {
                carOfferApi.update({id:this.id},carOffer).then(result =>
                result.json().then(data=>{
                    var index = getIndex(this.carOffers,data.id);
                    this.carOffers.splice(index, 1, data);

                }))
            } else {
            carOfferApi.save({}, carOffer).then(result =>
                result.json().then(data => {
                    this.carOffers.push(data);

                })
            )
        }
            this.id = '';
            this.brandName = '';
            this.modelName = '';
            this.gearBoxType = '';
            this.fuelType = '';
            this.cityName = '';
            this.description = '';
            this.year = '';
            this.mileage = '';
            this.price = '';
        }
    }
});


Vue.component('car-offer-row', {

    props: ['carOffer','carOffers','editMethod','pageVisebility'],
    template: '<div> {{ carOffer.id }} {{ carOffer.brandName }} {{ carOffer.modelName }}'+
        '<input type="button" value="View" @click="view" />' +
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="Delete" @click="del" />' +
        '</div>',
    methods: {
        view: function () {

        },
        edit: function () {
            this.editMethod(this.carOffer)
        },
        del: function () {
            carOfferApi.remove({id: this.carOffer.id}).then(result => {
                if (result.ok) {
                    this.carOffers.splice(this.carOffers.indexOf(0), 1);
                    this.carOffers.splice(this.carOffers.indexOf(1), 1);
                    this.carOffers.splice(this.carOffers.indexOf(2), 1);
                    this.carOffers.splice(this.carOffers.indexOf(3), 1);
                    this.carOffers.splice(this.carOffers.indexOf(4), 1);
                    this.carOffers.splice(this.carOffers.indexOf(5), 1);
                    this.carOffers.splice(this.carOffers.indexOf(6), 1);
                    this.carOffers.splice(this.carOffers.indexOf(7), 1);
                    this.carOffers.splice(this.carOffers.indexOf(8), 1);
                    this.carOffers.splice(this.carOffers.indexOf(9), 1);
                    carOfferApi.get().then(result =>
                        result.json().then(data =>
                            data.content.forEach(carOffer => this.carOffers.push(carOffer))))
                }
            })
        }
}});

Vue.component('car-offer-list', {
    props: ['carOffers'],
    data: function () {
        return {
            pageNumb: 0,
            mainPageV: true,
            updatePageV: false,
            viewPageV: false,
            carOffer: null,
            nextPageAvailable: false,
            last : true
        }
    },
    watch: {
        last: function(){
            this.nextPageCheck()
        }
    },
    template:
        '<div>' +
        '<div >' +
        '<input  type="button" value="Refresh" @click="refreshPage" />' +
        '<input v-if="nextPageAvailable" type="button" value="Next Page" @click="nextPage" />'+
        '<div > <car-offer-form v-if="updatePageV" :carOffers="carOffers" :carOfferAttr="carOffer" /></div>' +
        '<car-offer-row v-if="mainPageV"  v-for="carOffer in carOffers" v-bind:key="carOffer.id" :carOffer="carOffer"' +
        ':carOffers="carOffers" :editMethod="editMethod" :pageVisebility="pageVisebility"/>' +
        '</div>' +
        '</div>',
    created: function () {
        this.refreshPage();
    },
    methods: {
        nextPageCheck:function (){
            if(this.last){
                this.nextPageAvailable = false
            }
            else {
                this.nextPageAvailable = true
            }
        },
        nextPage:function (){
        this.pageNumb++,
            this.refreshPage()
        },
        refreshPage: function (){
            this.carOffers.splice(this.carOffers.indexOf(0), 1);
            this.carOffers.splice(this.carOffers.indexOf(1), 1);
            this.carOffers.splice(this.carOffers.indexOf(2), 1);
            this.carOffers.splice(this.carOffers.indexOf(3), 1);
            this.carOffers.splice(this.carOffers.indexOf(4), 1);
            this.carOffers.splice(this.carOffers.indexOf(5), 1);
            this.carOffers.splice(this.carOffers.indexOf(6), 1);
            this.carOffers.splice(this.carOffers.indexOf(7), 1);
            this.carOffers.splice(this.carOffers.indexOf(8), 1);
            this.carOffers.splice(this.carOffers.indexOf(9), 1);
            this.$http.get('/api/carOffer',{params: {page: this.pageNumb}})
                .then(response => response.json())
                .then(response => {
                    this.last = response.last
                    response.content.forEach(carOffer => this.carOffers.push(carOffer))

                })
            ;

                },

        pageVisebility: function (mainPageV,updatePageV,viewPageV){
            this.mainPageV = mainPageV;
            this.updatePageV = updatePageV;
            this.viewPageV = viewPageV;
        },
        editMethod: function (carOffer) {
            this.carOffer = carOffer;
        }
    }
});


var app = new Vue({
    el: '#app',
    template: '<car-offer-list :carOffers="carOffers" />',
    data: {

        carOffers: []
    }
});
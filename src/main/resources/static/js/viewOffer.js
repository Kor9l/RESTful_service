var carOfferApi = Vue.resource('/api/carOffer{/id}');

Vue.component('car-offer-form', {
    props: ['carOffers'],
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
        '<div><input type="button" value="Save" v-on:click="save" /></div>' +
        '</div>',
    created: function () {
        carOfferApi.get().then(result =>
            console.log(result)
            )

    },
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
                    price: this.price
                };
            carOfferApi.save({}, carOffer).then(result =>
                result.json().then(data => {
                    this.carOffers.push(data);
                    this.brandName = '';
                    this.modelName = '';
                    this.gearBoxType = '';
                    this.fuelType = '';
                    this.cityName = '';
                    this.description = '';
                    this.year = '';
                    this.mileage = '';
                    this.price = '';
                })
            )
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<car-offer-form :carOffers="carOffers" />',
    data: {

        carOffers: []
    }
});
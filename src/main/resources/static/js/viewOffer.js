var carOfferApi = Vue.resource('/api/carOffer{/id}');
var carOfferId = window.createCarOffer_js_carOfferId || "1";


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
        '<div><input type="text" v-model="brandName" placeholder ={{ carOffer.brandName }} /></div>' +
        '<div><input type="text" v-model="modelName" placeholder ={{ carOffer.modelName }} /></div>' +
        '<div><input type="text" v-model="gearBoxType" placeholder ={{ carOffer.gearBoxType }} /></div>' +
        '<div><input type="text" v-model="fuelType" placeholder ={{ carOffer.fuelType }} /></div>' +
        '<div><input type="text" v-model="cityName" placeholder ={{ carOffer.cityName }} /></div>' +
        '<div><input type="text" v-model="description" placeholder ={{ carOffer.description }} /></div>' +
        '<div><input type="text" v-model="year" placeholder ={{ carOffer.year }} /></div>' +
        '<div><input type="text" v-model="mileage" placeholder ={{ carOffer.mileage }} /></div>' +
        '<div><input type="text" v-model="price" placeholder ={{ carOffer.price }} /></div>' +
        '<div><input type="button" value="Save" v-on:click="save" /></div>' +
        '</div>',
    created: function () {
        carOfferApi.get(1).then(result =>
            result.json().then(data =>
                data.forEach(carOffer => this.carOffers.push(carOffer))
            )
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
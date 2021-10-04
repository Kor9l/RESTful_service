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


Vue.component('car-offer-row', {

    props: ['carOffer','carOffers'],
    template: '<div> {{ carOffer.id }} {{ carOffer.brandName }} {{ carOffer.modelName }}'+
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="Delete" @click="del" />' +
        '</div>',
    methods: {
        edit: function () {},
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
            mainPageV: true,
            updatePageV: false
        }
    },

    template:
        '<div>' +
        '<div >' +
        '<div > <car-offer-form :carOffers="carOffers" /></div>' +
        '<car-offer-row v-if="mainPageV"  v-for="carOffer in carOffers" v-bind:key="carOffer.id" :carOffer="carOffer"' +
        ':carOffers="carOffers" />' +
        '</div>' +
        '</div>',
    created: function () {
        carOfferApi.get().then(result =>
            result.json().then(data =>
                data.content.forEach(carOffer => this.carOffers.push(carOffer))
            )
        )
    }
});


var app = new Vue({
    el: '#app',
    template: '<car-offer-list :carOffers="carOffers" />',
    data: {

        carOffers: []
    }
});
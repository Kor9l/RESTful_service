function getIndex(list, id) {
    for (var i = 0; i < list.length; i++) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
}

var carOfferApi = Vue.resource('/api/carOffer{/id}');

Vue.component('car-view', {
        props: ['carOfferView'],
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
                id: '',
                seller: ''

            }
        },

        template:
            '<div>' +
            '<table>' +
            '<tr>' +
            '<td> Car offer ID  </td>' +
            '<td> {{ id }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Brand  </td>' +
            '<td> {{ brandName }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Model  </td>' +
            '<td> {{ modelName }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Gear box type  </td>' +
            '<td> {{ gearBoxType }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Fuel type  </td>' +
            '<td> {{ fuelType }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> City  </td>' +
            '<td> {{ cityName }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Description </td>' +
            '<td> {{ description }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Year  </td>' +
            '<td> {{ year }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Mileage  </td>' +
            '<td> {{ mileage }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Price  </td>' +
            '<td> {{ price }} </td>' +
            '</tr>' +
            '<tr>' +
            '<td> Seller  </td>' +
            '<td> {{ seller }} </td>' +
            '</tr>' +
            '</table>' +
            '</div>',

        created: function () {
            this.brandName = this.carOfferView.brandName
            this.id = this.carOfferView.id
            this.modelName = this.carOfferView.modelName
            this.fuelType = this.carOfferView.fuelType
            this.cityName = this.carOfferView.cityName
            this.description = this.carOfferView.description
            this.year = this.carOfferView.year
            this.mileage = this.carOfferView.mileage
            this.price = this.carOfferView.price
            this.gearBoxType = this.carOfferView.gearBoxType
            this.seller = this.carOfferView.sellerFullName
        },

    }
)

Vue.component('car-offer-form', {
    props: ['carOffers', 'carOfferAttr', 'backToMain'],
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
            id: '',
            errorMessage: ''

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
        '<br>'+
        '<span>Error message: {{ errorMessage }} </span>' +
        '</div>',
    created: function () {
        if (this.carOfferAttr.id != 0) {
            this.brandName = this.carOfferAttr.brandName
            this.id = this.carOfferAttr.id
            this.modelName = this.carOfferAttr.modelName
            this.fuelType = this.carOfferAttr.fuelType
            this.cityName = this.carOfferAttr.cityName
            this.description = this.carOfferAttr.description
            this.year = this.carOfferAttr.year
            this.mileage = this.carOfferAttr.mileage
            this.price = this.carOfferAttr.price
            this.gearBoxType = this.carOfferAttr.gearBoxType
        }


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
                    price: this.price,
                };
            if (this.id) {
                carOfferApi.update({id: this.id}, carOffer).then(response => {
                    this.id = ''
                    this.brandName = ''
                    this.modelName = ''
                    this.gearBoxType = ''
                    this.fuelType = ''
                    this.cityName = ''
                    this.description = ''
                    this.year = ''
                    this.mileage = ''
                    this.price = ''
                    this.carOfferAttr.id = 0
                    this.backToMain()
                },response =>{
                    this.errorMessage = response.body.errors[0].message
                })
            } else {
                carOfferApi.save({}, carOffer).then(response => {
                    this.id = ''
                    this.brandName = ''
                    this.modelName = ''
                    this.gearBoxType = ''
                    this.fuelType = ''
                    this.cityName = ''
                    this.description = ''
                    this.year = ''
                    this.mileage = ''
                    this.price = ''
                    this.carOfferAttr.id = 0
                    this.backToMain()
                },response =>{
                    this.errorMessage = response.body.errors[0].message
                })

            }

        }
    }
});


Vue.component('car-offer-row', {

    props: ['carOffer', 'carOffers', 'editMethod', 'goToEdit', 'refreshPage', 'goToView'],
    template: '<div> {{ carOffer.id }} {{ carOffer.brandName }} {{ carOffer.modelName }}' +
        '<input type="button" value="View" @click="view" />' +
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="Delete" @click="del" />' +
        '</div>',
    methods: {
        view: function () {
            this.editMethod(this.carOffer)
            this.goToView()
        },
        edit: function () {
            this.editMethod(this.carOffer)
            this.goToEdit()
        },
        del: function () {
            carOfferApi.remove({id: this.carOffer.id}).then(result => {
                if (result.ok) {
                    this.refreshPage()
                }
            })
        }
    }
});

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
            last: true,
            first: true,
            currentPage: 1,
            previousPageAvailable: false,
            totalPages: 0,
            brandName: '',
            modelName: '',
            sort: ''

        }
    },
    watch: {
        last: function () {
            this.nextPageCheck()
        },
        first: function () {
            this.previousPageCheck()
        }
    },
    template:
        '<div>' +
        '<div  v-if="updatePageV" >' +
            '<car-offer-form :carOffers="carOffers" :carOfferAttr="carOffer" ' +
            ':backToMain="backToMain"/>' +
        '</div>' +

        '<div v-if="mainPageV">' +
            '<input type="button" value="New offer" @click="goToEdit" /><br><br>' +
            '<span>Filters: </span><br>' +
            '<div>' +
            '<select type="select" v-model="brandName"><option disabled value="">Please select one</option>' +
            '<option>Audi</option><option>Renault</option><option>BMW</option><option>Mersedes</option><option>Peguet</option>' +
            '<option>WV</option><option>Citroen</option></select>' +
            '<select type="select" v-model="modelName"><option disabled value="">Please select one</option>' +
            '<option>TT</option><option>Logan</option><option>740</option><option>Crafter</option><option>Berlingo</option>' +
            '<option>Partner</option></select><br>' +
            '<span>Sort: </span><br>' +
            '<select type="select" v-model="sort"><option disabled value="">Please select one</option>' +
            '<option>id,ASC</option><option>id,DESC</option><option>brandName,ASC</option><option>brandName,DESC</option>'+
            '<option>modelName,ASC</option> <option>modelName,DESC</option></select><br>' +
            '<input type="button" value="Search" @click="refreshPage" />' +
            '</div>' +
            '<br>' +
            '<input v-if="previousPageAvailable"  type="button" value="Previous page" @click="previousPage" />' +
            '<input v-if="nextPageAvailable" type="button" value="Next page" @click="nextPage" />' +
            '<car-offer-row   v-for="carOffer in carOffers" v-bind:key="carOffer.id" :carOffer="carOffer"' +
            ':carOffers="carOffers" :editMethod="editMethod" :goToEdit="goToEdit" :refreshPage="refreshPage"' +
            ' :goToView="goToView"/>'+
            '<span>Curren page number: {{ currentPage }} </span>' +
            '<span>Total pages: {{ totalPages }} </span>' +
        '</div>' +

        '<div v-if="viewPageV" >' +
            '<car-view :carOfferView="carOffer" />' +
            '<input type="button" value="Back" @click="backToMain">' +
        '</div>' +
        '</div>',
    created: function () {
        this.refreshPage()
    },
    methods: {
        goToEdit: function () {
            this.updatePageV = true
            this.mainPageV = false
        },
        goToView: function () {
            this.mainPageV = false
            this.viewPageV = true
        },
        backToMain: function () {
            this.updatePageV = false
            this.mainPageV = true
            this.viewPageV = false
            this.refreshPage()
        },
        nextPageCheck: function () {
            if (this.last) {
                this.nextPageAvailable = false
            } else {
                this.nextPageAvailable = true
            }
        },
        previousPageCheck: function () {
            if (this.first) {
                this.previousPageAvailable = false
            } else {
                this.previousPageAvailable = true
            }
        },
        nextPage: function () {
            this.pageNumb++,

                this.refreshPage()
        },
        previousPage: function () {
            this.pageNumb--,
                this.refreshPage()
        },

        clearOffers: function () {
            this.carOffers.splice(this.carOffers.indexOf(0), 1)
            this.carOffers.splice(this.carOffers.indexOf(1), 1)
            this.carOffers.splice(this.carOffers.indexOf(2), 1)
            this.carOffers.splice(this.carOffers.indexOf(3), 1)
            this.carOffers.splice(this.carOffers.indexOf(4), 1)
            this.carOffers.splice(this.carOffers.indexOf(5), 1)
            this.carOffers.splice(this.carOffers.indexOf(6), 1)
            this.carOffers.splice(this.carOffers.indexOf(7), 1)
            this.carOffers.splice(this.carOffers.indexOf(8), 1)
            this.carOffers.splice(this.carOffers.indexOf(9), 1)
        },

        refreshPage: function () {
            this.clearOffers()
            this.$http.get('/api/carOffer', {
                params: {
                    page: this.pageNumb,
                    model: this.modelName,
                    brand: this.brandName,
                    sort: this.sort
                }
            })
                .then(response => response.json())
                .then(response => {
                    this.last = response.last
                    this.first = response.first
                    this.totalPages = response.totalPages
                    this.currentPage = response.number + 1
                    response.content.forEach(carOffer => this.carOffers.push(carOffer))
                })
        },

        editMethod: function (carOffer) {

            this.carOffer = carOffer
        }
    }
})

var app = new Vue({
    el: '#app',
    template: '<car-offer-list :carOffers="carOffers" />',

    data: {

        carOffers: []
    }
})
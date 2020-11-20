import Navbar from '../components/Navbar.vue';

export default {
    title: 'Navbar',
    component: Navbar,
};

export const DefaultState = () => ({
    components: {
        navbar: Navbar
    },
    template: `<navbar> </navbar>`

});
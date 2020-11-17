import Navbar from '../components/Navbar.vue';

export default {
    title: 'Navbar',
    component: Navbar,
};

export const DefaultState = () => ({
    components: {
        chart: Navbar
    },
});
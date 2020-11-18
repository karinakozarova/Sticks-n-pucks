import TeamCard from '../components/TeamCard.vue';
export default {
    title: 'TeamCard',
    component: TeamCard,
};

export const DefaultState = () => ({
    components: {
        chart: TeamCard
    },
    template: `<chart v-bind:teamname="'Hawks'" v-bind:description="'Best team'" />`
});

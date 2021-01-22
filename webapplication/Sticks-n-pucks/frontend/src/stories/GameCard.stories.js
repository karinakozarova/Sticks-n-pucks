import GameCard from '../components/GameCard.vue';
export default {
    title: 'GameCard',
    component: GameCard,
};

export const DefaultState = () => ({
    components: {
        card: GameCard
    },
    template: `<card v-bind:hostname="'Hawks'" v-bind:guestname="'Best team'"  v-bind:hostscore="'1'" v-bind:guestscore="'2'" v-bind:gamedate="'2020-12-2'"/>`
});

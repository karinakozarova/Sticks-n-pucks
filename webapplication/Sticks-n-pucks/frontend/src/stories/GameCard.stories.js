import GameCard from '../components/GameCard.vue';
export default {
    title: 'GameCard',
    component: GameCard,
};

export const DefaultState = () => ({
    components: {
        card: GameCard
    },
    template: `<card v-bind:hostName="'Hawks'" v-bind:guestName="'Best team'"  v-bind:hostScore="'1'" v-bind:guestScore="'2'" v-bind:gameDate="'2020-12-2'"/>`
});

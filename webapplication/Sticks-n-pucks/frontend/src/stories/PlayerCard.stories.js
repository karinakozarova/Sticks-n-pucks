import PlayerCard from '../components/PlayerCard.vue';
export default {
    title: 'PlayerCard',
    component: PlayerCard,
};

export const DefaultState = () => ({
    components: {
        card: PlayerCard
    },
    template: `<card v-bind:playername="'Patrics Kane'" v-bind:height="'164'"  v-bind:weight="'64'" v-bind:shoots="'Left'" v-bind:position="'LW'"/>`
});
